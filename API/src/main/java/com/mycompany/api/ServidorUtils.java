package com.mycompany.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// Utilidad para convertir objetos Java a JSON
public class ServidorUtils {

    // JSON con formato bonito (pretty printing)
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }
}