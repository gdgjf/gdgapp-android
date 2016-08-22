package com.gdg.eventmanager.architecture;

import com.bluelinelabs.logansquare.typeconverters.DateTypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by atilabraga on 8/22/16.
 */

public class DateOnlyDateConverter extends DateTypeConverter {

    private DateFormat mDateFormat;

    public DateOnlyDateConverter() {
        mDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public DateFormat getDateFormat() {
        return mDateFormat;
    }

}