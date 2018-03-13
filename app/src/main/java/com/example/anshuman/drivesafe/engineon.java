package com.example.anshuman.drivesafe;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class engineon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineon);


        new Timer().schedule(new TimerTask(){
            public void run() {
                startActivity(new Intent(engineon.this, Profile.class));
            }
        }, 4200);
    }
}
