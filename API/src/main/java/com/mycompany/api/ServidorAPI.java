package com.mycompany.api;

import static spark.Spark.*;
import com.google.gson.Gson;

public class ServidorAPI {
    public static void main(String[] args) {

        port(4567); // Puerto donde correrá la API

        Gson gson = new Gson();

        // --- Primer endpoint de prueba ---
        get("/test", (req, res) -> {
            res.type("application/json");
            return gson.toJson("API funcionando correctamente");
        });

    }
}