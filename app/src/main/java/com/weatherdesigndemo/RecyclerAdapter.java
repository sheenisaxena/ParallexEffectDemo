package com.weatherdesigndemo;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agc-android on 21/3/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> hourTempList, temperatueList;
    private List<Integer> imagesModeList;

    public RecyclerAdapter(Context context, List<Integer> imageslList, List<String> hourList, List<String> templist) {
        this.context = context;
        this.imagesModeList = imageslList;
        this.hourTempList = hourList;
        this.temperatueList = templist;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_hours, tv_humidity_temperature;
        public ImageView iv_desc;


        public MyViewHolder(View view) {
            super(view);
            tv_hours = (TextView) view.findViewById(R.id.tv_hours);
            tv_humidity_temperature = (TextView) view.findViewById(R.id.tv_humidity_temperature);
            iv_desc = (ImageView) view.findViewById(R.id.iv_desc);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.inflate_recycler_item_view, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder recholder, int position) {
        MyViewHolder holder = (MyViewHolder) recholder;

        holder.iv_desc.setImageResource(imagesModeList.get(position));
        holder.tv_hours.setText(hourTempList.get(position));
        holder.tv_humidity_temperature.setText(temperatueList.get(position));
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return hourTempList.size();
    }

}
