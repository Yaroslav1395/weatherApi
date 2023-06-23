package com.weatherService.weather.service.weatherApi;

public enum WeatherApiPaths {
    WEATHER_BIT_URI("http://api.weatherbit.io/v2.0/current?key=0de82339923d4a68af685a9b157beda1&city=Cholpon-Ata"),
    WEATHER_API_URI("https://api.weatherapi.com/v1/current.json?key=660a8d150d534cb59cf190032232006&q=balykchi"),
    OPEN_WEATHER_URI("https://api.openweathermap.org/data/2.5/weather?q=karakol&appid=0d63180cb80ad7e76f0decd3154d3b57");
    private final String url;

    WeatherApiPaths(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
