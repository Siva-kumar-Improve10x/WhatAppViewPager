package com.example.whatappviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.whatappviewpager.WhatsApp.MyViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPagerVg;
    private MyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setUpAdapter();
        connectAdapter();
    }

    private void connectAdapter() {
        viewPagerVg.setAdapter(adapter);
    }

    private void setUpAdapter() {
        adapter = new MyViewPagerAdapter(this);
    }

    private void initViews() {
        viewPagerVg = findViewById(R.id.viewpager_vg);
    }
}