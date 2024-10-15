package com.example.viewpagerapp;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewpager;
    ViewPagerAdapter viewPagerAdapter;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        tabLayout = findViewById(R.id.tabLayout);


//        Adding fragments to the list in the Adapter class
        viewPagerAdapter.addFragment(new Fragment1());
        viewPagerAdapter.addFragment(new Fragment2());
        viewPagerAdapter.addFragment(new Fragment3());
        viewPagerAdapter.addFragment(new Fragment4());

//        Set the orientation in viewPager

        viewpager = findViewById(R.id.viewPager);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

//        Connecting the Adapter with the viewPager
        viewpager.setAdapter(viewPagerAdapter);

//        Connecting Tab Layout with ViewPager
        new TabLayoutMediator(
                tabLayout,
                viewpager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
                        tab.setText("Fragment " +(i + 1));

                    }
                }
                ).attach();
    }
}