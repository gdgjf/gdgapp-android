package com.gdg.eventmanager.architecture.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.architecture.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atilabraga on 8/10/16.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_tab_layout)
    TabLayout tab;
    @BindView(R.id.main_view_pager)
    ViewPager viewPager;
    MainPagerAdapter adapter;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_main);

        adapter = new MainPagerAdapter(MainActivity.this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
    }
}
