package com.gdg.eventmanager.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.api.GDGApi;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by atilabraga on 3/17/16.
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_til_email)
    TextInputLayout tilEmail;
    @BindView(R.id.login_til_password)
    TextInputLayout tilPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        GDGApi.init(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public boolean hasBackButton() {
        return false;
    }

    @OnClick(R.id.login_btn_login)
    public void onLoginClick() {
        String email = tilEmail.getEditText().getText().toString();
        String password = tilPassword.getEditText().getText().toString();
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            GDGApi.getInstance().authenticate(email, password);
        }
    }

}
