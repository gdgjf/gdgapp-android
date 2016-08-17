package com.gdg.eventmanager.architecture.login;

import com.gdg.eventmanager.model.User;

/**
 * Created by atilabraga on 8/10/16.
 */

public interface LoginInteractor {

    interface OnLoginListener {
        void onSuccess(User user);
    }

    void autenticate(String user, String password, OnLoginListener listener);

}
