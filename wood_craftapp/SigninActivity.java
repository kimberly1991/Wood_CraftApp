package com.example.wood_craftapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity {

    private EditText  username1, password1, confirmpass;
    private Button signup_btn;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        username1 = (EditText) findViewById(R.id.username1);
        password1 = (EditText) findViewById(R.id.password1);
        confirmpass = (EditText) findViewById(R.id.confirmpass);

        signup_btn = (Button) findViewById(R.id.signup_btn);

        DB = new DBHelper(this);
        insertUser();

    }

    private void insertUser(){
        signup_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v) {
                boolean var = DB.registerUser(username1.getText().toString() , password1.getText().toString() , confirmpass.getText().toString());
                 if (var){
                     Toast.makeText(SigninActivity.this, "User Register Successfully!!", Toast.LENGTH_SHORT).show();
                 }
                 else
                     Toast.makeText(SigninActivity.this, "Registration error!", Toast.LENGTH_SHORT).show();
            }

        });

    }
}