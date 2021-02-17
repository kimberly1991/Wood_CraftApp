package com.example.wood_craftapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        5
                


        View recyclerView = findViewById(R.id.recyclerView);

        ArrayList <MAHOGANY> list = new ArrayList<>();

        list.add(new MAHOGANY(R.drawable.bedqs , "Bed Queen Size"));
        list.add(new MAHOGANY(R.drawable.bedqs , "Bed Queen Size"));
        list.add(new MAHOGANY(R.drawable.bedqs , "Bed Queen Size"));
        list.add(new MAHOGANY(R.drawable.bedqs , "Bed Queen Size"));ss


    }
}