package com.example.anshuman.drivesafe;

import android.location.Location;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
public class sos extends AppCompatActivity {
    EditText msg;
    Button btnSendSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        msg=(EditText)findViewById(R.id.etxt);
        btnSendSms=(Button)findViewById(R.id.sendsms);GoogleApiClient mGoogleApiClient;

       /* mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();

        mGoogleApiClient.connect();*/

        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSms();
            }
            protected void sendSms() {
                String number= "9962368035";
                String loc="https://goo.gl/maps/1iZkzLghhpv";
                String message= "Hey I am in Emergency.";
                message+=loc;

                message+=msg.getText().toString();

                SmsManager manager= SmsManager.getDefault();
                manager.sendTextMessage(number,null,message,null,null);
                Toast.makeText(getApplicationContext(), "Send Successfully", Toast.LENGTH_LONG).show();
                Intent inte = new Intent(sos.this, Profile.class);
                startActivity(inte);
            }
        });
    }
}
