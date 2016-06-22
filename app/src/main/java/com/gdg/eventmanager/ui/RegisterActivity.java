package com.gdg.eventmanager.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gdg.eventmanager.R;

/**
 * Created by atilabraga on 3/19/16.
 */
public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    public boolean hasBackButton() {
        return false;
    }
}
