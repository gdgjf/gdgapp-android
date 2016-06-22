package com.gdg.eventmanager.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.ui.adapter.MainPagerAdapter;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.main_tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.main_view_pager)
    ViewPager mViewPager;

    MainPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new MainPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        getSupportActionBar().setTitle(R.string.title_main);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public boolean hasBackButton() {
        return false;
    }
}
