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
    private TextView pTxt1,pTxt2,pTxt3;
    private EditText pTxtInput1;
    private Button pBtn1,pBtn2,pBtn3;
    private Slider pSld;
    Engine pEngine = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // UI elements descriptions
        pTxt1 = findViewById(R.id.txt1);
        pTxt2 = findViewById(R.id.txt2);
        pTxt3=findViewById(R.id.txt3);
        pBtn1 = findViewById(R.id.btn1);
        pBtn2 = findViewById(R.id.btn2);
        pBtn3=findViewById(R.id.btn3);
        pSld = findViewById(R.id.sld1);
        //pTxtInput1=findViewById(R.id.txtInput1);

        // UI elements initialisation
        pTxt1.setText(null);
        pTxt2.setText(null);

        // Engine create
        pEngine = new Engine(30);
        pEngine.fillDataRandom();
        //pTxt1.setText(pEngine.getData());

        // TODO here
        // Button NEW DATA listener
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
        // Button ACTION listener
        pBtn3.setOnClickListener(view -> {
            pTxt3.setText(pEngine.actionStart());
        });
        // Slider Listener
        pSld.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                float pF = slider.getValue();
                int i = (int) pF;
                pEngine = new Engine(i);
                pEngine.fillDataRandom();
                pTxt1.setText(pEngine.getData());
            }
        });
    }


}