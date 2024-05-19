package sprint9.weather_client;

import java.util.HashMap;

public class WeatherApplication {
    private HashMap<String, String> weatherData;
    WeatherClient weatherClient = new WeatherClient();

    public WeatherApplication() {
        initializedData();
    }

    // инициализация статических данных о погоде
    private void initializedData() {
        weatherData = new HashMap<>();
        weatherData.put("MOW", "Город: Москва. Облачно, +5°C");
        weatherData.put("LED", "Санкт-Петербург. Дождливо, +3°C");
        weatherData.put("KZN", "Город: Казань. Солнечно, +12°C");
    }

    // метод для отображения погоды
    public void displayWeather(String city) {
    // замените данные на динамические, полученные через weatherClient
//        String weatherData = this.weatherData.getOrDefault(city, "Данные о погоде не найдены");
        System.out.println(weatherClient.getWeatherData(city));
    }
}