package sprint9.weather_client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {
    private final HttpClient client;

    public WeatherClient() {
        client = HttpClient.newHttpClient();
    }

    public String getWeatherData(String city) {
        URI uri = URI.create("https://functions.yandexcloud.net/d4eo3a1nvqedpic89160?scale=C&city=" + city);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int code = response.statusCode();
            if (code != 200) {
                return "Что-то пошло не так. Сервер вернул код состояния: " + code;
            }
            JsonElement jsonElement = JsonParser.parseString(response.body());
            JsonObject jsonObject = jsonElement.getAsJsonObject().get("cities").getAsJsonObject().get(city).getAsJsonObject();
            String responseCity = jsonObject.get("city").getAsString();
            String conditions = jsonObject.get("conditions").getAsString();
            String temperature = jsonObject.get("temperature").getAsString();
            return "Город: " + responseCity + ". " + conditions + ", " + temperature;
        } catch (Exception e) {
            return "Во время выполнения запроса возникла ошибка.\n" +
                    "Проверьте, пожалуйста, параметры запроса и повторите попытку.";
        }
    }
}
