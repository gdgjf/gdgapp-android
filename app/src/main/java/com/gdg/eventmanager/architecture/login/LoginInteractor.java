package com.gdg.eventmanager.architecture.login;

/**
 * Created by atilabraga on 8/10/16.
 */

public interface LoginInteractor {

    interface OnLoginListener {
        void onSuccess();
    }

    void login(String user, String password, OnLoginListener listener);

}
