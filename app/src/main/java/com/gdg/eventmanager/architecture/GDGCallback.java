package com.gdg.eventmanager.architecture;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by atilabraga on 8/16/16.
 */

public abstract class GDGCallback<T> implements Callback<T> {

    public abstract void onSuccess(Call<T> call, T data);

    public abstract void onFailure(Call<T> call, Throwable t, String error);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(call, response.body());
        } else {
            onFailure(call, null, "");
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailure(call, t, "");
    }

}