package com.gdg.eventmanager.architecture.login;

import android.util.Log;

import com.gdg.eventmanager.api.GDGApi;
import com.gdg.eventmanager.architecture.GDGCallback;
import com.google.gson.JsonElement;

import retrofit2.Call;

/**
 * Created by atilabraga on 8/10/16.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void autenticate(String user, String password, OnLoginListener listener) {
        GDGCallback<JsonElement> callback = new GDGCallback<JsonElement>() {
            @Override
            public void onSuccess(Call<JsonElement> call, JsonElement data) {
                Log.d("::::::", data.toString());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t, String error) {
                Log.d("::::::", "onFailure");
            }
        };
        GDGApi.getInstance().authenticate(user, password).enqueue(callback);
    }

}
