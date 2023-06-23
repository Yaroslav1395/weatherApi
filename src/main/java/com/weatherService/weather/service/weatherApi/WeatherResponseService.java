package com.weatherService.weather.service.weatherApi;


public interface WeatherResponseService {
    void saveWeatherToDataBaseFromWeatherApi();
    void saveWeatherToDataBaseFromWeatherBitApi();
    void saveWeatherToDataBaseFromWeatherOpenApi();
}
