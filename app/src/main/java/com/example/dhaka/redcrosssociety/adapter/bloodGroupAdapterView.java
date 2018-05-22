package com.example.dhaka.redcrosssociety.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dhaka.redcrosssociety.R;
import com.example.dhaka.redcrosssociety.model.bloodGroup;

import java.util.List;

public class bloodGroupAdapterView extends BaseAdapter {
    private Context context;
    private List<bloodGroup> bloodGroupListViewList;

    @Override
    public int getCount() {
        return bloodGroupListViewList.size();
    }

    @Override
    public Object getItem(int position) {
        return bloodGroupListViewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.blood_group_list_view_item, null);
        TextView textView = (TextView) view.findViewById(R.id.blood_group);
        textView.setText(bloodGroupListViewList.get(position).getBloodGroupString());
        return view;
    }

    public bloodGroupAdapterView(Context context, List<bloodGroup> bloodGroupListViewList) {
        this.context = context;
        this.bloodGroupListViewList = bloodGroupListViewList;
    }
}
