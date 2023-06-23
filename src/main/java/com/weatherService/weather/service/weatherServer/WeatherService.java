package com.weatherService.weather.service.weatherServer;

import com.weatherService.weather.dto.weatherDto.WeatherDto;

import java.util.List;

public interface WeatherService {
    public List<WeatherDto> getWeatherForecastForToday();
}
