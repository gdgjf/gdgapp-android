package com.gdg.eventmanager.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.gdg.eventmanager.model.User;
import com.gdg.eventmanager.util.PreferencesConstants;

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
    private static final String X_TOKEN = "X-TOKEN";

    private static GDGApi sInstance;
    private SharedPreferences mPreferences;
    private GDGService mService;

    private GDGApi(Context context) {
        mPreferences = context.getSharedPreferences(PreferencesConstants.PREFS_NAME_USER,
                Context.MODE_PRIVATE);
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                if (mPreferences.contains(PreferencesConstants.API_MD5)
                        && mPreferences.contains(PreferencesConstants.USER_ID)) {
                    int userId = mPreferences.getInt(PreferencesConstants.USER_ID, 0);
                    String apiMd5 = mPreferences.getString(PreferencesConstants.API_MD5, "");

                    Request.Builder requestBuilder = request.newBuilder()
                            .addHeader(X_API_USER_ID, String.valueOf(userId))
                            .addHeader(X_API_TOKEN, apiMd5);
                    if (mPreferences.contains(PreferencesConstants.X_TOKEN)) {
                        String xToken = mPreferences.getString(PreferencesConstants.X_TOKEN, "");
                        requestBuilder
                                .addHeader(X_TOKEN, xToken)
                                .build();
                    } else {
                        requestBuilder.build();
                    }
                }

                Response response = chain.proceed(request);
                return response;
            }
        }).build();

//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(Level.BASIC);
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .build();

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

    public Call<User> authenticate(String email, String password) {
        return mService.authenticate(email, password);
    }

}
