package com.gdg.eventmanager.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by atilabraga on 3/15/16.
 */
public interface GDGService {

    @POST("autenticar/")
    Call<JsonObject> authenticate();

    @POST("eventos/")
    Call<JsonObject> events();

    @POST("evento/{id}")
    Call<JsonObject> event(@Path("id") String id);

    @GET("inscricao/{id}")
    Call<JsonObject> registration(@Path("id") String id);

}
