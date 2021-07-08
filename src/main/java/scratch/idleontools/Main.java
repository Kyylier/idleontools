package scratch.idleontools;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/** Grabs your account save from Firestore. */
public final class Main {

    private static final String API_BASE_URL = "https://firestore.googleapis.com/v1";
    private static final String PROJECT_NAME = "idlemmo";
    private static final String DATABASE = "(default)";
    private static final String API_KEY = "AIzaSyAU62kOE6xhSrFqoXQPv6_WHxYilmoUxDk";
    private static final String DOCUMENT = "_data/{chrId}?key=" + API_KEY;

    // TODO: How to get a fresh ID_TOKEN without manually finding it in Chrome? It expires pretty quickly.
    private static final String ID_TOKEN = "{very_secret}";
    private static final String APP_ID = "1:267901585099:web:541850859230c27619bd4e";


    public static void main(String[] args) throws IOException {
        URL url = new URL(API_BASE_URL + "/projects/" + PROJECT_NAME + "/databases/" + DATABASE + "/documents/" + DOCUMENT + "?key=" + API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + ID_TOKEN);
        String responseBody = new String(connection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(responseBody);
    }
}
