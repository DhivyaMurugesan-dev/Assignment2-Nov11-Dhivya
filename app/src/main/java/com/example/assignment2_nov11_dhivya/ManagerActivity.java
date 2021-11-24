package com.example.assignment2_nov11_dhivya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ManagerActivity  extends AppCompatActivity implements View.OnClickListener {
    ArrayList<HistoryModel> productHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerview);
        Button btnhistory;
        Button btnrestock;


        btnhistory = (Button) findViewById(R.id.btnhistory);
        btnrestock = (Button) findViewById(R.id.btnrestock);

        btnhistory.setOnClickListener(this);
        btnrestock.setOnClickListener(this);
        productHistory = this.getIntent().getExtras().getParcelableArrayList("history list");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnhistory) {
            //Intent is used to navigate from one screen to another screen

            Intent historyIntent = new Intent(getApplicationContext(), HistoryView.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("history list", productHistory);
            historyIntent.putExtras(bundle);

            ManagerActivity.this.startActivity(historyIntent);

        }
//        else (v.getId()==R.id.btnrestock){
//            Intent restockIntent = new Intent(getApplicationContext(),RestockActivity.class);
//            Bundle bundle = new Bundle();
//            //bundle.putParcelableArrayList("Stock list");
//
//        }
//        }


    }
}

