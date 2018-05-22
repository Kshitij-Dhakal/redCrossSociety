package com.example.dhaka.redcrosssociety.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhaka.redcrosssociety.R;

public class personDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getIntent().getExtras().getString("INTENT_NAME"));

        TextView contactTextView = (TextView) findViewById(R.id.detail_person_contact);
        contactTextView.setText(getIntent().getExtras().getString("INTENT_CONTACT"));
        TextView addressTextView = (TextView) findViewById(R.id.detail_person_address);
        addressTextView.setText(getIntent().getExtras().getString("INTENT_ADDRESS"));
        TextView genderTextView = (TextView) findViewById(R.id.detail_person_gender);
        genderTextView.setText(getIntent().getExtras().getString("INTENT_GENDER"));
        TextView bloodGroupTextView = (TextView) findViewById(R.id.detail_person_blood_group);
        bloodGroupTextView.setText(getIntent().getExtras().getString("INTENT_BLOOD_GROUP"));

        /**
         * Floating Action Button onClick Listner
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + getIntent().getExtras().getString("INTENT_CONTACT")));
                if (ActivityCompat.checkSelfPermission(personDetail.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED || intent.resolveActivity(getPackageManager()) == null) {
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(personDetail.this, "Could Not Make Call", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
            }
        });
    }
}
