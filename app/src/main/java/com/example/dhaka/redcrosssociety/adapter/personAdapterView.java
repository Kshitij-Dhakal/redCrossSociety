package com.example.dhaka.redcrosssociety.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dhaka.redcrosssociety.R;
import com.example.dhaka.redcrosssociety.model.person;

import java.util.List;

public class personAdapterView extends BaseAdapter {
    private Context context;
    private List<person> personList;

    public personAdapterView(Context context, List<person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.person_list_view_item, null);
        TextView name = (TextView) view.findViewById(R.id.person_name);
        name.setText(personList.get(position).getFname() + " " + personList.get(position).getLname());
//        TextView contact = (TextView) view.findViewById(R.id.person_contact);
//        contact.setText(personList.get(position).getContact());
        TextView address = (TextView) view.findViewById(R.id.person_address);
        address.setText(personList.get(position).getAddress());
        return view;
    }

}
