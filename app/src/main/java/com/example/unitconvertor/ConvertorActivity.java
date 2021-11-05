 package com.example.unitconvertor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

 public class ConvertorActivity extends AppCompatActivity {

     private String[] titles1 = {"currency","temp.","length","weight"};
     private int[] titles = {
             R.drawable.money,
             R.drawable.sun,
             R.drawable.ruler,
             R.drawable.weight};
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        TabLayout tabLayout= findViewById(R.id.tabs);
        ViewPager2 viewPager2=findViewById(R.id.view_pager);


        ViewPagerAdapter adapter=new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);


        new TabLayoutMediator(tabLayout,viewPager2,new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                 tab.setIcon(titles[position]);
                 tab.setText(titles1[position]);
            }
        }).attach();


    }




}