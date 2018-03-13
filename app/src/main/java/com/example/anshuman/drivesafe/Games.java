package com.example.anshuman.drivesafe;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.Random;
import android.content.Intent;
import android.widget.Toast;
public class Games extends AppCompatActivity implements SensorEventListener
{
    String strValue;
    private int counter=0;
    private float mLastX, mLastY, mLastZ;
    private boolean mInitialized; private SensorManager mSensorManager; private Sensor mAccelerometer; private final float NOISE = (float) 2.0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        mInitialized = false;
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Random r = new Random();
        final int na=r.nextInt(4-1)+1;
        int Low = 1;
        int High = 9;
        //final int Result = r.nextInt(High - Low) + Low;
        switch (na){
            case 1:

                TextView confirms = (TextView) findViewById(R.id.textView);
                confirms.setText("Enter the Captcha :" );
                ImageView confirm = (ImageView) findViewById(R.id.imageView);
                confirm.setImageResource(R.drawable.cap3);
                Button bu = (Button) findViewById(R.id.ok);
                bu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final EditText simpleEditText = (EditText) findViewById(R.id.input);
                        strValue = simpleEditText.getText().toString();
                        if (strValue.equals("2OPB47")) {
                            Toast.makeText(getApplicationContext(), "Engine Switching On", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Games.this, engineon.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong, Try Again", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Games.this, Profile.class);
                            startActivity(i);
                        }
                    }
                });
                break;
            case 2:

                ImageView confir = (ImageView) findViewById(R.id.imageView);
                confir.setImageResource(R.drawable.cap1);
                Button b = (Button) findViewById(R.id.ok);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final EditText simpleEditText = (EditText) findViewById(R.id.input);
                        strValue = simpleEditText.getText().toString();
                        if (strValue.equals("PV6261")) {
                            Toast.makeText(getApplicationContext(), "Engine Switching On", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Games.this, engineon.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong, Try Again", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Games.this, Profile.class);
                            startActivity(i);
                        }
                    }
                });
                break;
            case 3:

                ImageView con = (ImageView) findViewById(R.id.imageView);
                con.setImageResource(R.drawable.cap2);
                Button but = (Button) findViewById(R.id.ok);
                but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final EditText simpleEditText = (EditText) findViewById(R.id.input);
                        strValue = simpleEditText.getText().toString();
                        if (strValue.equals("31HJR2"))
                        {
                            Toast.makeText(getApplicationContext(), "Engine Switching On", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Games.this, engineon.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Wrong, Try Again", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Games.this, Profile.class);
                            startActivity(i);
                        }
                    }
                });
                break;
        }
    }


    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
// can be safely ignored for this demo
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        TextView tvX= (TextView)findViewById(R.id.x_axis);
        TextView tvY= (TextView)findViewById(R.id.y_axis);
        TextView tvZ= (TextView)findViewById(R.id.z_axis);
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        if (!mInitialized) {
            mLastX = x;
            mLastY = y;
            mLastZ = z;
            tvX.setText("0.0");
            tvY.setText("0.0");
            tvZ.setText("0.0");
            mInitialized = true;
        } else {
            float deltaX = Math.abs(mLastX - x);
            float deltaY = Math.abs(mLastY - y);
            float deltaZ = Math.abs(mLastZ - z);
            if (deltaX < NOISE) deltaX = (float)0.0;
            if (deltaY < NOISE) deltaY = (float)0.0;
            if (deltaZ < NOISE) deltaZ = (float)0.0;
            mLastX = x;
            mLastY = y;
            mLastZ = z;
           tvX.setText(Float.toString(deltaX));
            tvY.setText(Float.toString(deltaY));
            tvZ.setText(Float.toString(deltaZ));
            if (deltaX+deltaY+deltaZ > 4.5)
            {
                counter =1;
                Intent i = new Intent(Games.this, Profile.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hands are Not Still, Try Again", Toast.LENGTH_SHORT).show();
            }
            else
            {
                counter = 0;

            }
        }
    }





}