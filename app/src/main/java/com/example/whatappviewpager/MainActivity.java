package com.example.whatappviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.whatappviewpager.WhatsApp.MyViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPagerVg;
    private TabLayout tabLayout;
    private MyViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setUpAdapter();
        connectAdapter();
        setUpTabWithViewPager();
    }

    private void setUpTabWithViewPager() {
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPagerVg, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 1:
                        tab.setText("Status");
                        break;
                    case 2:
                        tab.setText("Calls");
                        break;
                    case 0:
                    default:
                        tab.setText("Chats");
                }
                }
            });
        tabLayoutMediator.attach();
    }

    private void connectAdapter() {
        viewPagerVg.setAdapter(adapter);
    }

    private void setUpAdapter() {
        adapter = new MyViewPagerAdapter(this);
    }

    private void initViews() {
        viewPagerVg = findViewById(R.id.viewpager_vg);
        tabLayout = findViewById(R.id.tab_layout);
    }
}