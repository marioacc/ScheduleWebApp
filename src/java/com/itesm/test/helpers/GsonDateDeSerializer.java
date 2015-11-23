package com.itesm.test.helpers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mario on 11/23/2015.
 */
public class GsonDateDeSerializer implements JsonDeserializer<Date> {



    private SimpleDateFormat format1 = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
    private SimpleDateFormat format2 = new SimpleDateFormat("HH:mm");



    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {

            String j = json.getAsJsonPrimitive().getAsString();
            System.out.println(j);
            return parseDate(j);
        } catch (ParseException e) {
            throw new JsonParseException(e.getMessage(), e);
        }
    }

    private Date parseDate(String dateString) throws ParseException {
        System.out.println(dateString);
        if (dateString != null && dateString.trim().length() > 0) {
            try {
                return format1.parse(dateString);
            } catch (ParseException pe) {
                System.out.println(pe.getMessage());
                return format2.parse(dateString);
            }
        } else {
            return null;
        }
    }

}

