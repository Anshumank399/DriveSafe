package com.example.anshuman.drivesafe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {
    //private FirebaseAuth mFirebaseAuth;
   // private
    /**
     * Id to identity READ_CONTACTS permission request.
     */
  //  private static final int REQUEST_READ_CONTACTS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FloatingActionButton reg = (FloatingActionButton) findViewById(R.id.regis);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, naya.class);
                startActivity(intent);
            }
        });

        final EditText edit_text = (EditText) findViewById(R.id.email);
        final EditText edit_text1 = (EditText) findViewById(R.id.password);
        Button b = (Button) findViewById(R.id.email_sign_in_button);
        b.setOnClickListener(new View.OnClickListener() {
            String user = "";
            String pass = "";
            @Override
            public void onClick(View v) {

                user = edit_text.getText().toString();
                pass = edit_text1.getText().toString();
                //String user="anshuman.kirty@gmail.com";
                //String pass ="qwerty";

                if (user.equals("anshuman.kirty@gmail.com") && pass.equals("qwerty"))
                {
                    Intent inte = new Intent(LoginActivity.this, Profile.class);
                    Toast.makeText(getApplicationContext(), "Logged In", Toast.LENGTH_SHORT).show();
                    startActivity(inte);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid Email/Password", Toast.LENGTH_SHORT).show();
                }



            }
        });



    }
}

