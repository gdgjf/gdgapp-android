package com.gdg.eventmanager.api;

import com.gdg.eventmanager.model.Event;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by atilabraga on 3/15/16.
 */
public interface GDGService {

    @FormUrlEncoded
    @POST("autenticar")
    Call<JsonElement> authenticate(@Field("email") String email, @Field("password") String password);

    @GET("eventos")
    Call<List<Event>> events();

    @GET("evento/{id}")
    Call<Event> event(@Path("id") String id);

    @GET("inscricao/{id}")
    Call<JsonObject> registration(@Path("id") String id);

}
