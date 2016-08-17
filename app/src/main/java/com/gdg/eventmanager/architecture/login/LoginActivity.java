package com.gdg.eventmanager.architecture.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.api.GDGApi;
import com.gdg.eventmanager.architecture.BaseActivity;
import com.gdg.eventmanager.architecture.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by atilabraga on 8/10/16.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.login_til_email)
    TextInputLayout tilEmail;
    @BindView(R.id.login_til_password)
    TextInputLayout tilPassword;

    LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        GDGApi.init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        tilEmail.getEditText().setText("braga.atila@gmail.com");
        tilPassword.getEditText().setText("123456");

        presenter = new LoginPresenterImpl(this);
    }

    @OnClick(R.id.login_btn_login)
    void onLoginClick(View view) {
        String user = tilEmail.getEditText().getText().toString();
        String password = tilPassword.getEditText().getText().toString();
        presenter.validateCredentials(user, password);
    }

    @Override
    public void startMain() {
        MainActivity.start(LoginActivity.this);
    }

    @Override
    public void display() {
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

}
