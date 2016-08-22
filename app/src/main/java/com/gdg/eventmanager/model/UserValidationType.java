package com.gdg.eventmanager.model;

/**
 * Created by atilabraga on 3/29/16.
 */
public enum UserValidationType {

    EMAIL("email");

    String value;

    UserValidationType(String value) {
        this.value = value;
    }

}
