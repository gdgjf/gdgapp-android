package com.gdg.eventmanager.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.gdg.eventmanager.util.PreferencesConstants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by atilabraga on 3/15/16.
 */
public class GDGApi {

    public static final String BASE_URL = "http://emjuizdefora.com/gdgjf/api/";

    private static GDGApi sInstance;
    private Retrofit mRetrofit;

    private GDGApi() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static void init() {
        if (sInstance == null) {
            sInstance = new GDGApi();
        }
    }

    public static GDGApi getInstance() {
        return sInstance;
    }

}
