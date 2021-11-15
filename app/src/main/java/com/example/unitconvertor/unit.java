package com.example.unitconvertor;

public class unit {
    private  String description;
    private int resid;//image id
    private boolean ishappy;
    private int amount;


    public unit(String description, int resid, boolean ishappy, int amount) {
        this.description = description;
        this.resid = resid;
        this.ishappy = ishappy;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public boolean isIshappy() {
        return ishappy;
    }

    public void setIshappy(boolean ishappy) {
        this.ishappy = ishappy;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
