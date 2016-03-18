package com.gdg.eventmanager.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gdg.eventmanager.R;

/**
 * Created by atilabraga on 3/17/16.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

}
