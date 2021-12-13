package com.example.unitconvertor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

public class unit implements Serializable {
    private  String description;
    private int resid;//image id
    private boolean ishappy;
    private int amount;
    private View tvfrom;
    private View tvto;
    private View tvresult;

public void stam(LayoutInflater inflater, ViewGroup container,
                 Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.row, container,false);
    tvfrom = rootView.findViewById(R.id.textViewfrom);
    tvto = rootView.findViewById(R.id.textviewto);
    tvresult = rootView.findViewById(R.id.resulttextview);
    Bundle extras = getIntent().getExtras();
    if (extras != null) {
        String value = extras.getString("from");
        //The key argument here must match that used in the other activity
    }
}


    public unit(String description, int resid, boolean ishappy, int amount) {
        this.description = description;
        this.resid = resid;
        this.ishappy = ishappy;
        this.amount = amount;





    }
    // public String getTvfrom(){return tvfrom;}
   // public String getTvresult(){return tvresult;}
   // public String getTvto(){return tvto;}
   // public void setTvfrom(String tvfrom){this.tvfrom=tvfrom;}
   // public void setTvresult(String tvresult){this.tvresult=tvresult;}
   // public void setTvto(String tvto){this.tvto=tvto;}



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
