package com.weatherdesigndemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemListAdapter extends BaseAdapter {

    ArrayList<String> dayItem = new ArrayList<>();
    ArrayList<String> arrMaxTempList = new ArrayList<>();
    ArrayList<String> arrMinTempList = new ArrayList<>();
    ArrayList<Integer> arrImagedescItem = new ArrayList<>();

    private static LayoutInflater inflater = null;
    Context context;

    public ItemListAdapter(Context ctx, ArrayList<String> dayItems, ArrayList<Integer> arrImagedescItems, ArrayList<String> arrMaxTempList, ArrayList<String> arrMinTempList) {
        context = ctx;
        this.dayItem = dayItems;
        this.arrImagedescItem = arrImagedescItems;
        this.arrMaxTempList = arrMaxTempList;
        this.arrMinTempList = arrMinTempList;

        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dayItem.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {

        ImageView iv_desc;
        TextView tv_days, tv_max_temp, tv_min_temp;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View vi = convertView;

        Log.v("pos", String.valueOf(position));

      /*  if (vi == null) {*/
            vi = inflater.inflate(R.layout.inflate_listview_item, null);
            holder = new ViewHolder();

            holder.iv_desc = (ImageView) vi.findViewById(R.id.iv_desc);
            holder.tv_days = (TextView) vi.findViewById(R.id.tv_days);
            holder.tv_max_temp = (TextView) vi.findViewById(R.id.tv_max_temp);
            holder.tv_min_temp = (TextView) vi.findViewById(R.id.tv_min_temp);
            vi.setTag(holder);

       /* } else {
            holder = (ViewHolder) vi.getTag();
        }*/


        holder.iv_desc.setImageResource(arrImagedescItem.get(position));
        holder.tv_days.setText(dayItem.get(position));
        holder.tv_max_temp.setText(arrMaxTempList.get(position));
        holder.tv_min_temp.setText(arrMinTempList.get(position));

        return vi;
    }
}
