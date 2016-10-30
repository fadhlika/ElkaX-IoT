package fi.elka.elkaxiot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fadhlika on 10/29/2016.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView titleView;
        public TextView dataView;

        public ViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.title);
            dataView = (TextView) itemView.findViewById(R.id.data);
        }
    }

    private Context context;
    private List<Data> dataList;

    public DataAdapter(Context context_, List<Data> dataList_){
        dataList = dataList_;
        context = context_;
    }

    private Context getContext(){
        return context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context_ =  parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context_);

        View unitView = inflater.inflate(R.layout.item_data, parent, false);

        ViewHolder viewHolder = new ViewHolder(unitView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Data data = dataList.get(position);

        TextView titleView_ = holder.titleView;
        titleView_.setText(data.title);
        TextView dataView_ = holder.dataView;
        dataView_.setText("" + data.unit);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void clear(){
        dataList.clear();
        notifyDataSetChanged();
    }

    public void addAll (List<Data> list){
        dataList.addAll(list);
        notifyDataSetChanged();
    }

}
