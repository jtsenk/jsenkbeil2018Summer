package com.jtsenkbeil.gsu.jsenkbeil2018summer.feature.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListNormalAdapter extends BaseAdapter {

    private final Context context;

    public ListNormalAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 15;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView tv = new TextView(context);
        tv.setText("");
        return null;
    }

}
