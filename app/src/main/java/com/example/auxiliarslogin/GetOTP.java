package com.example.auxiliarslogin;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class GetOTP extends Activity {
    EditText u, p;
    String userName, password, phonenum;
    Button getotp;
    FirebaseDatabase mFirebaseInstance;
    DatabaseReference mFirebaseDatabase;
    String userId;
    DatabaseReference rootRef, demoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u = findViewById(R.id.username);
        userName = u.getText().toString();
        p = findViewById(R.id.password);
        password = p.getText().toString();
        getotp = (Button) findViewById(R.id.getotp);
        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRef = rootRef.child("OTP");
        getotp.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String us = u.getText().toString();
                String pass = p.getText().toString();
                User u=new User(us,pass);
                demoRef.push().setValue(u);

            }
        });
    }
}