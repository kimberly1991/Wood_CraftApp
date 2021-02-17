package com.example.wood_craftapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText username , password;
    private Button login_btn, create_btn;
    private DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        login_btn = findViewById(R.id.login_btn);
        create_btn = findViewById(R.id.create_btn);




        DB = new DBHelper(this);
        loginUser();
    }

    private void loginUser(){
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = DB.checkUser(username.getText().toString() , password.getText().toString());
                if (var) {
                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this , HomeActivity.class));
                    finish();
                }

                else
                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();

            }




        });


        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, SigninActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}