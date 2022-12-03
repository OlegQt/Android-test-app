package com.practicum.fortestsapp;

import android.os.Build;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class Engine {
    private ArrayList<Integer> data = null;
    private HashMap<String, String> pMap = new HashMap<>();
    private int dataSize;

    // Constructor
    public Engine(int dataSize) {
        this.data = new ArrayList<>();
        this.dataSize = dataSize;
    }

    // Functions
    public void fillDataRandom() {
        Random pR = new Random();
        if (this.data != null) {
            this.data.clear();
            for (int i = 0; i < this.dataSize; i++) {
                this.data.add(pR.nextInt(10));
            }
        }
    }
    public String getData() {
        String strData = "";
        for (Integer item : this.data) {
            strData = strData.concat(item.toString() + " ");
        }
        //return "txt";
        return strData;
    }
    boolean sortData(int left, int right) {
        if (data == null) return false;
        else if (right - left > 1) {
            int pivot = data.get(((right - left) / 2) + left);
            int i = left;
            int j = right;

            boolean leftStop = false, rightStop = false;
            while (i < j) {
                if (data.get(i) >= pivot) leftStop = true;
                if (data.get(j) <= pivot) rightStop = true;
                if (!leftStop) i++;
                if (!rightStop) j--;
                if (leftStop && rightStop && (i <= j)) {
                    int temp = data.get(j);
                    Integer pItem = data.get(j);
                    pItem = new Integer(data.get(i));
                    pItem = data.get(j);
                    pItem = new Integer(temp);
                    j--;
                    leftStop = false;
                    rightStop = false;
                }
            }
            if (left < j) sortData(left, j);
            if (right > i) sortData(i, right);
            return true;
        }
        return false;
    }
    void sortAuto() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.data.sort(Comparator.naturalOrder());
        }
    }
}
