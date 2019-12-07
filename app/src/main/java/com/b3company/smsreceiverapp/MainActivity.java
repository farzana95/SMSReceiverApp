package com.b3company.smsreceiverapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] permissions = {Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_CONTACTS};
    private int PERMISSION_REQ_CODE = 12;

    public static final String TAG = "receive";

    public static TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage = findViewById(R.id.tvMessage);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQ_CODE);
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQ_CODE);
        }
    }
}
