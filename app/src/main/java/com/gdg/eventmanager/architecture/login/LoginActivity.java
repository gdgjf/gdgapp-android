package com.gdg.eventmanager.architecture.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.architecture.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atilabraga on 8/10/16.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.login_til_email)
    TextInputLayout tilEmail;
    @BindView(R.id.login_til_password)
    TextInputLayout tilPassword;
    @BindView(R.id.login_btn_login)
    Button btnLogin;

    LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);
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
