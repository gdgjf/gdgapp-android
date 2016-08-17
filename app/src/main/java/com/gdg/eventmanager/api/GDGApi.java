package com.gdg.eventmanager.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.gdg.eventmanager.util.PreferencesConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by atilabraga on 3/15/16.
 */
public class GDGApi {

    public static final String BASE_URL = "http://emjuizdefora.com/gdgjf/api/";
    private static final String X_API_USER_ID = "X-API-USER-ID";
    private static final String X_API_TOKEN = "X-API-TOKEN";

    private static GDGApi sInstance;
    private SharedPreferences mPreferences;
    private GDGService mService;
    private Gson gson = new GsonBuilder()
            .create();

    private GDGApi(Context context) {
        mPreferences = context.getSharedPreferences(PreferencesConstants.PREFS_NAME_USER,
                Context.MODE_PRIVATE);
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                builder.addHeader("Content-Type", "application/json;charset=UTF-8");
                builder.addHeader("Accept", "application/json");
                if (mPreferences.contains(PreferencesConstants.API_MD5)
                        && mPreferences.contains(PreferencesConstants.USER_ID)) {
                    int userId = mPreferences.getInt(PreferencesConstants.USER_ID, 0);
                    String apiMd5 = mPreferences.getString(PreferencesConstants.API_MD5, "");

                    builder.addHeader(X_API_USER_ID, String.valueOf(userId))
                            .addHeader(X_API_TOKEN, apiMd5)
                            .build();
                }

                Response response = chain.proceed(request);
                return response;
            }
        }).build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        mService = mRetrofit.create(GDGService.class);
    }

    public static void init(Context context) {
        if (sInstance == null) {
            sInstance = new GDGApi(context);
        }
    }

    public static GDGApi getInstance() {
        return sInstance;
    }

    public Call<JsonElement> authenticate(String email, String password) {
        return mService.authenticate(email, password);
    }

}
