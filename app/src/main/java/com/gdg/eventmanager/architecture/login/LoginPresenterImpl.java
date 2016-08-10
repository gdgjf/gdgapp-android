package com.gdg.eventmanager.architecture.login;

/**
 * Created by atilabraga on 8/10/16.
 */

public class LoginPresenterImpl implements LoginPresenter {

    LoginView loginView;
    LoginInteractor loginInteractor;

    LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
    }

}
