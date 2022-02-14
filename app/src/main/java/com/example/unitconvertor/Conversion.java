package com.example.unitconvertor;

import android.widget.EditText;

public class Conversion {
    private String type;
    private int from;
    private int to;
    private Double result;
    private String key;

    public Conversion (String type,int from,int to,Double result){
        this.type=type;
        this.from=from;
        this.to=to;
        this.result=result;
    }
    public Conversion(String conversion, EditText from, double result){}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
