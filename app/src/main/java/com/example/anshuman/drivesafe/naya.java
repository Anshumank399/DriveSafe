package com.example.anshuman.drivesafe;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import com.example.anshuman.add.data.AddContract.AddEntry;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


//import com.example.anshuman.add.data.AddDbHelper;
/**
 * Created by ANSHUMAN on 21-03-2017.
 */

public class naya extends AppCompatActivity {
    //  private AddDbHelper mDbHelper;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("Profile").push();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button btn_go = (Button) findViewById(R.id.register);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText simEditText1 = (EditText) findViewById(R.id.emailid);
                String email = simEditText1.getText().toString();
                final EditText simEditText2 = (EditText) findViewById(R.id.pass);
                String pass = simEditText2.getText().toString();
                final EditText simpleEditText = (EditText) findViewById(R.id.reg);
                String regno = simpleEditText.getText().toString();
                final EditText sEditText = (EditText) findViewById(R.id.name);
                String name = sEditText.getText().toString();
                final EditText siEditText = (EditText) findViewById(R.id.phone);
                String number = siEditText.getText().toString();
                final EditText simEditText = (EditText) findViewById(R.id.license);
                String licen = simEditText.getText().toString();

                if(regno.equals(""))
                    Toast.makeText(getApplicationContext(), "NOT REGISTERED !!", Toast.LENGTH_SHORT).show();
                else if(name.equals(""))
                    Toast.makeText(getApplicationContext(), "NOT REGISTERED !!", Toast.LENGTH_SHORT).show();
                else if (number.equals(""))
                    Toast.makeText(getApplicationContext(), "NOT REGISTERED !!", Toast.LENGTH_SHORT).show();
                else if(licen.equals(""))
                    Toast.makeText(getApplicationContext(), "NOT REGISTERED !!", Toast.LENGTH_SHORT).show();
                else if(email.equals("")) {
                    Toast.makeText(getApplicationContext(), "NOT REGISTERED !!", Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals(""))
                    Toast.makeText(getApplicationContext(), "NOT REGISTERED !!", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(getApplicationContext(), "REGISTERED !!", Toast.LENGTH_SHORT).show();
                    //mMessagesDatabaseReference.push();
                    mMessagesDatabaseReference.child("Email").setValue(email);
                    mMessagesDatabaseReference.child("Password").setValue(pass);
                    mMessagesDatabaseReference.child("RegNo").setValue(regno);
                    mMessagesDatabaseReference.child("Name").setValue(name);
                    mMessagesDatabaseReference.child("Phone").setValue(number);
                    mMessagesDatabaseReference.child("License").setValue(licen);
                }
                Intent i = new Intent(naya.this, LoginActivity.class);
                startActivity(i);

            }
        });
    }



}
