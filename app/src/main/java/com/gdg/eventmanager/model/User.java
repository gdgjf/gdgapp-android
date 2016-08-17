package com.gdg.eventmanager.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by atilabraga on 3/30/16.
 */
@JsonObject
public class User {

    @JsonField(name = "id")
    long id;
    @JsonField(name = "organizador")
    boolean organizer;
    @JsonField(name = "nome")
    String name;
    @JsonField(name = "cpf")
    String cpf;
    @JsonField(name = "email")
    String email;
    @JsonField(name = "celular")
    String phone;
    @JsonField(name = "extras")
    List<Extra> extras;



}
