package com.practicum.fortestsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Add global variables here
    private TextView pTxt1,pTxt2;
    private EditText pTxtInput1;
    private Button pBtn1,pBtn2;
    private Slider pSld;
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
        pSld = findViewById(R.id.sld1);
        //pTxtInput1=findViewById(R.id.txtInput1);

        // UI elements initialisation
        pTxt1.setText(null);
        pTxt2.setText("Second text");

        // Engine create
        pEngine = new Engine(30);
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

        pSld.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {
                Float pF = slider.getValue();
                int i = pF.intValue();
                pEngine = new Engine(i);
                pEngine.fillDataRandom();
                pTxt1.setText(pEngine.getData());
            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                Float pF = slider.getValue();
                int i = pF.intValue();
                pEngine = new Engine(i);
                pEngine.fillDataRandom();
                pTxt1.setText(pEngine.getData());
            }
        });
        pSld.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                Float pF = slider.getValue();
                int i = pF.intValue();
                pEngine = new Engine(i);
                pEngine.fillDataRandom();
                pTxt1.setText(pEngine.getData());
            }
        });
    }


}