package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.R;

import java.util.ArrayList;

public class AdvanceListViewAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<String> list;
    private final LayoutInflater inflater;

    public AdvanceListViewAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("ViewHolder","getView");
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_advance_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.rl_odd = (RelativeLayout) convertView.findViewById(R.id.odd);
            viewHolder.rl_even = (RelativeLayout) convertView.findViewById(R.id.even);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        if (position % 2 != 0) {
            //position is odd
            viewHolder.rl_odd.setVisibility(View.VISIBLE);
            viewHolder.rl_even.setVisibility(View.INVISIBLE);
        } else {
            //position is even
            viewHolder.rl_odd.setVisibility(View.INVISIBLE);
            viewHolder.rl_even.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    private class ViewHolder {
        RelativeLayout rl_odd;
        RelativeLayout rl_even;

        ViewHolder() {
            rl_odd = null;
            rl_even = null;
        }
    }

}

