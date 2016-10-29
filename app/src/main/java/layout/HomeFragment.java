package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fi.elka.elkaxiot.Data;
import fi.elka.elkaxiot.DataAdapter;
import fi.elka.elkaxiot.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        //Data dummy
        ArrayList<Data> listData = new ArrayList<Data>();
        listData.add(new Data("Temperature", 24.0));
        listData.add(new Data("Humidity", 68.0));

        DataAdapter dataAdapter = new DataAdapter(getActivity(), listData);
        RecyclerView itemRecycleView = (RecyclerView) v.findViewById(R.id.rv_home);
        itemRecycleView.setAdapter(dataAdapter);
        itemRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inflate the layout for this fragment
        return v;
    }

}
