package com.gdg.eventmanager.architecture;

import com.bluelinelabs.logansquare.typeconverters.StringBasedTypeConverter;
import com.gdg.eventmanager.model.UserValidationType;

/**
 * Created by atilabraga on 8/22/16.
 */

public class UserValidationTypeConverter extends StringBasedTypeConverter<UserValidationType> {

    @Override
    public UserValidationType getFromString(String s) {
        return UserValidationType.valueOf(s);
    }

    public String convertToString(UserValidationType object) {
        return object.toString();
    }

}