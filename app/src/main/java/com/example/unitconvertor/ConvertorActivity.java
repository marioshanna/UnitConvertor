 package com.example.unitconvertor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

 public class ConvertorActivity extends AppCompatActivity {

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
                tab.setText("Tab"+(position+1));
            }
        }).attach();
    }

}