package com.gdg.eventmanager.architecture.login;

import com.gdg.eventmanager.model.User;

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
        loginView.showProgress();
        LoginInteractor.OnLoginListener listener = new LoginInteractor.OnLoginListener() {
            @Override
            public void onSuccess(User user) {
                loginView.startMain();
            }
        };
        loginInteractor.autenticate(username, password, listener);
    }

}
