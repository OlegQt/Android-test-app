package com.practicum.fortestsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Add global variables here
    private TextView pTxt1,pTxt2;
    private Button pBtn1,pBtn2;
    Engine pEngine = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // UI elements descriptions
        pTxt1 = findViewById(R.id.txt1);
        pTxt2 = findViewById(R.id.txt2);
        pBtn1 = findViewById(R.id.btn1);
        pBtn2 = findViewById(R.id.btn2);

        // UI elements initialisation
        pTxt1.setText(null);
        pTxt2.setText("Second text");

        // Engine create
        pEngine = new Engine(6);
        pEngine.fillDataRandom();
        pTxt1.setText(pEngine.getData());

        // TODO here
        pBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pEngine.fillDataRandom();
                pTxt1.setText(pEngine.getData());
            }
        });
        // Button SORT DATA Listener
        pBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pEngine.sortData(1,10);
                pEngine.sortAuto();
                pTxt2.setText(pEngine.getData());
            }
        });
    }


}