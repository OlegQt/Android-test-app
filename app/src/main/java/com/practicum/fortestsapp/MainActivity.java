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
    // Functions
    String getDataTxt(int [] data) {
        if(data==null)
        {
            return "Empty DATA[]";
        }
        else
        {
            String str="";
            for (int i = 0; i < data.length; i++)
            {
                str=str.concat(data[i]+"  ");
            }
            //str=str.concat("\n");
            return str;
        }

    }
    boolean sortData(int left,int right, int data[]){
        if(data==null) return false;
        else if(right-left>1) {
            int pivot = data[((right - left) / 2)+left];
            int i = left;
            int j = right;

            boolean leftStop=false,rightStop=false;
            while(i<j)
            {
                if(data[i]>=pivot) leftStop=true;
                if(data[j]<=pivot) rightStop=true;
                if(!leftStop) i++;
                if(!rightStop) j--;
                if(leftStop&&rightStop&&(i<=j))
                {
                    int temp = data[j];
                    data[j]=data[i];
                    data[i]=temp;
                    i++;
                    j--;
                    leftStop=false;
                    rightStop=false;
                }
            }
            if(left<j) sortData(left,j,data);
            if(right>i) sortData(i,right,data);
            return true;
        }
        else return false;
    }

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

        // TODO here
        int data[]  ={6,9,4,5,9};// new int[6];
        pTxt1.setText(getDataTxt(data));
        // Button NEW DATA Listener
        pBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random pR = new Random();
                for (int i = 0; i < data.length; i++) {
                    data[i]=pR.nextInt(10);
                }
                pTxt1.setText(getDataTxt(data));
            }
        });
        // Button SORT DATA Listener
        pBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pTxt2.setText("Button has been push");
                sortData(0, data.length-1, data);
                //Arrays.sort(data); // Сортировка массива с помощью встроенных функций
                pTxt2.setText(getDataTxt(data));
            }
        });
    }


}