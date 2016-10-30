package layout;


import android.net.Proxy;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import fi.elka.elkaxiot.Data;
import fi.elka.elkaxiot.DataAdapter;
import fi.elka.elkaxiot.DataClient;
import fi.elka.elkaxiot.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ArrayList<Data> listData = new ArrayList<Data>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        final DataAdapter dataAdapter = new DataAdapter(getActivity(), listData);


        //Data dummy
        DataClient.get("current", null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response){

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray datas){
                JSONArray currentDatas = datas;
                try {
                    JSONObject temp = currentDatas.getJSONObject(0);
                    JSONObject humid = currentDatas.getJSONObject(1);
                    double temp_ = temp.getDouble("temp");
                    double humid_ = humid.getDouble("humid");
                    listData.add(new Data("Humidity", humid_));
                    listData.add(new Data("Temperature", temp_));
                    dataAdapter.notifyDataSetChanged();
                    Log.d("fromJSON", "" + temp_);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });


        RecyclerView itemRecycleView = (RecyclerView) v.findViewById(R.id.rv_home);
        itemRecycleView.setAdapter(dataAdapter);
        itemRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inflate the layout for this fragment
        return v;
    }

}
