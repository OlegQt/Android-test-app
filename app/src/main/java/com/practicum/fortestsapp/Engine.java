package com.practicum.fortestsapp;

import java.util.ArrayList;
import java.util.Random;

public class Engine {
    private ArrayList<Integer> data = null;
    private int dataSize;
    // Constructor
    public Engine(int dataSize){
        this.data = new ArrayList<Integer>();
        this.dataSize = dataSize;
    }

    // Functions
    public void fillDataRandom(){
        Random pR = new Random();
        for (int i=0;i<this.dataSize;i++){
            this.data.add(new Integer(pR.nextInt(10)));
        }
    }
    public String getData(){
        String strData = "";
        for (Integer item:this.data) {
            strData = strData.concat(item.toString());
        }
        //return "txt";
        return strData;
    }
}
