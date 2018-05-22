package com.example.dhaka.redcrosssociety;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dhaka.redcrosssociety.activities.findBlood;
import com.example.dhaka.redcrosssociety.adapter.bloodGroupAdapterView;
import com.example.dhaka.redcrosssociety.model.bloodGroup;
import com.example.dhaka.redcrosssociety.data.dbHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.example.dhaka.redcrosssociety.data.dbHelper.DB_LOCATION;
import static com.example.dhaka.redcrosssociety.data.dbHelper.DB_NAME;

public class MainActivity extends AppCompatActivity {
    public static dbHelper mdbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_item);
        final List<bloodGroup> bloodGroups = new ArrayList<>();
        bloodGroups.add(new bloodGroup("O Positive", "OP"));
        bloodGroups.add(new bloodGroup("O Negative", "ON"));
        bloodGroups.add(new bloodGroup("A Positive", "AP"));
        bloodGroups.add(new bloodGroup("A Negative", "AN"));
        bloodGroups.add(new bloodGroup("B Positive", "BP"));
        bloodGroups.add(new bloodGroup("B Negative", "BN"));
        bloodGroups.add(new bloodGroup("AB Positive", "ABP"));
        bloodGroups.add(new bloodGroup("AB Negative", "ABN"));
        bloodGroupAdapterView groupAdapterView = new bloodGroupAdapterView(this, bloodGroups);
        listView.setAdapter(groupAdapterView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bloodGroup bloodGroup = bloodGroups.get(position);
                Intent intent = new Intent(MainActivity.this, findBlood.class);
                intent.putExtra("BLOOD_GROUP_INTENT",bloodGroup.getId());
                intent.putExtra("TITLE",bloodGroup.getBloodGroupString());
                startActivity(intent);
            }
        });
        mdbHelper = new dbHelper(this);

        //copy Database
        File file = getApplicationContext().getDatabasePath(DB_NAME);
        if (!file.exists()) {
            mdbHelper.getReadableDatabase();
            if (copyDatabase(this)) {
                Toast.makeText(this, "Database Copy Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Database Could Not Be Copied", Toast.LENGTH_SHORT).show();
            }
        }

    }

    /**
     * Copy Database from assets folder into databases folder
     *
     * @param context Context
     * @return True if database was copied successfully into databases folder. False otherwise
     */
    public boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DB_NAME);
            OutputStream outputStream = new FileOutputStream(DB_LOCATION + DB_NAME);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            outputStream.flush();
            inputStream.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
