package com.example.dhaka.redcrosssociety.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dhaka.redcrosssociety.MainActivity;
import com.example.dhaka.redcrosssociety.R;
import com.example.dhaka.redcrosssociety.adapter.personAdapterView;
import com.example.dhaka.redcrosssociety.model.person;

import java.util.List;

import static com.example.dhaka.redcrosssociety.MainActivity.mdbHelper;

public class findBlood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);
        ListView listView = (ListView) findViewById(R.id.person_list);
        final Context context = this;
        setTitle(getIntent().getExtras().getString("TITLE"));
        //If the query returns empty then throws Exception
        try {
            final List<person> personList = mdbHelper.getPersonList("blood_group = ?",
                    new String[]{getIntent().getExtras().getString("BLOOD_GROUP_INTENT")}); //get query from database into List
            personAdapterView personAdapterView = new personAdapterView(this, personList);
            listView.setAdapter(personAdapterView);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    person person = personList.get(position);
                    Intent intent = new Intent(context, personDetail.class);
                    intent.putExtra("INTENT_NAME", person.getFname() + " " + person.getLname());
                    intent.putExtra("INTENT_GENDER", person.getGender());
                    intent.putExtra("INTENT_ADDRESS", person.getAddress());
                    intent.putExtra("INTENT_CONTACT", person.getContact());
                    intent.putExtra("INTENT_BLOOD_GROUP", person.getBlood_group());
                    startActivity(intent);

                }
            });
        } catch (Exception e) {
            Toast.makeText(this, "No Data For Given Query", Toast.LENGTH_SHORT).show();
        }

    }

}
