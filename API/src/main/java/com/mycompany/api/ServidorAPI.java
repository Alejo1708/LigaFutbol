// ENDPOINT 3 jhosusruiz: GET /estadios
        // Devuelve todos los estadios con nombre, ciudad, capacidad
        // --------------------------------------------------------------------------------------------------
        Spark.get("/estadios", (req, res) -> {
            res.type("application/json");

            List<Estadio> lista = new ArrayList<>();

            for (String e : DatosLiga.ESTADIOS) {
                String[] partes = e.split(", ");

                String nombre = partes[0];
                String ciudad = partes[1];
                int capacidad = Integer.parseInt(partes[2]);

                lista.add(new Estadio(nombre, ciudad, capacidad));
            }

            return ServidorUtils.toJson(lista);
        });

        System.out.println("Servidor API corriendo en http://localhost:4567/");
    }
}