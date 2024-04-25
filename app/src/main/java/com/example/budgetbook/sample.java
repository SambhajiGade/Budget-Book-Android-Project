package com.example.budgetbook;

import android.util.Log;

import java.util.ArrayList;

public class sample {

    public ArrayList<String> sam = new ArrayList<>();
    public ArrayList<String> sam1 = new ArrayList<>();
    public sample(){}

    public sample(ArrayList<String> sam, ArrayList<String> sam1){
        this.sam = sam;
        this.sam1 = sam1;
    }

    public ArrayList<String> getSam(){
        return sam;
    }
    public ArrayList<String> getSam1(){
        return sam1;
    }

    public void setSam(ArrayList<String> sam){
        this.sam = sam;
    }

    public void setSam1(ArrayList<String> sam1){
        this.sam1 = sam1;
    }
}
