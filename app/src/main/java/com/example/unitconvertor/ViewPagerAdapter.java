package com.example.unitconvertor;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity){super(fragmentActivity);}
    @Override
    @NonNull

    public Fragment createFragment(int position){
        switch (position){
            case 0:
                return new currencyFragment();
            case 1:
                return new TempFragment();
            case 2:
                return new SizeFragment();
            default:
                return new WeightFragment();
        }
    }
    @Override
    public int getItemCount(){return 4;}




}
