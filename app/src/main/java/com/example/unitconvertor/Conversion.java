package com.example.unitconvertor;

import android.widget.EditText;

public class Conversion {
    private String type;
    private int from;
    private int to;
    private Double result;
    private String key;
    private double fromnum;
    private String fromtype;
    private String totype;

    public Conversion() {
    }

    public Conversion(String type, int from, int to, Double result, double fromnum, String fromtype, String totype) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.result = result;
        this.fromnum = fromnum;
        this.fromtype = fromtype;
        this.totype = totype;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getFromnum() {
        return fromnum;
    }

    public void setFromnum(double fromnum) {
        this.fromnum = fromnum;
    }

    public String getFromtype() {
        return fromtype;
    }

    public void setFromtype(String fromtype) {
        this.fromtype = fromtype;
    }

    public String getTotype() {
        return totype;
    }

    public void setTotype(String totype) {
        this.totype = totype;
    }
}