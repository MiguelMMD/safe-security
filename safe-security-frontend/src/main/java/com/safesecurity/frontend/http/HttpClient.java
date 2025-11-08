package com.safesecurity.frontend.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    private static final String BASE_URL = "http://localhost:9090"; // URL de tu backend
    private static final int TIMEOUT = 8000;

    // ✅ MÉTODO POST (para login y registro)
    public static String post(String path, String json) throws IOException {
        URL u = new URL(BASE_URL + path);
        HttpURLConnection con = (HttpURLConnection) u.openConnection();
        con.setRequestMethod("POST");
        con.setConnectTimeout(TIMEOUT);
        con.setReadTimeout(TIMEOUT);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            os.write(json.getBytes());
        }

        return readResponse(con);
    }

    // ✅ MÉTODO GET (para contactos, dispositivos, alertas)
    public static String get(String path) throws IOException {
        URL u = new URL(BASE_URL + path);
        HttpURLConnection con = (HttpURLConnection) u.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(TIMEOUT);
        con.setReadTimeout(TIMEOUT);

        return readResponse(con);
    }

    // ✅ LECTURA DE RESPUESTA DEL SERVIDOR
    private static String readResponse(HttpURLConnection con) throws IOException {
        int status = con.getResponseCode();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        status >= 200 && status < 300
                                ? con.getInputStream()
                                : con.getErrorStream()
                )
        )) {
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();
        }
    }
}
