package com.gdg.eventmanager.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by atilabraga on 8/17/16.
 */
@JsonObject
public class Extra {

    @JsonField(name = "Titulo")
    String name;
    @JsonField(name = "Valor")
    String value;

}
