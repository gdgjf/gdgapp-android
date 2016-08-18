package com.gdg.eventmanager.architecture.login;

import android.util.Log;

import com.bluelinelabs.logansquare.LoganSquare;
import com.gdg.eventmanager.api.GDGApi;
import com.gdg.eventmanager.architecture.GDGCallback;
import com.gdg.eventmanager.model.User;
import com.google.gson.JsonElement;

import java.io.IOException;

import retrofit2.Call;

/**
 * Created by atilabraga on 8/10/16.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void autenticate(String user, String password, final OnLoginListener listener) {
        GDGCallback<JsonElement> callback = new GDGCallback<JsonElement>() {
            @Override
            public void onSuccess(Call<JsonElement> call, JsonElement data) {
                User user = null;
                try {
                    JsonElement userJson = data.getAsJsonObject().get("pessoa");
                    if (userJson != null) {
                        user = LoganSquare.parse(userJson.toString(), User.class);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                listener.onSuccess(user);
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t, String error) {
                Log.d("::::::", "onFailure");
            }
        };
        GDGApi.getInstance().authenticate(user, password).enqueue(callback);
    }

}
