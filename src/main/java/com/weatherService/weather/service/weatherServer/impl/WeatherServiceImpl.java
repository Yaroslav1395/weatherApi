package com.weatherService.weather.service.weatherServer.impl;

import com.weatherService.weather.dto.mappers.WeatherMappers;
import com.weatherService.weather.dto.weatherDto.WeatherDto;
import com.weatherService.weather.model.Weather;
import com.weatherService.weather.repository.WeatherRepository;
import com.weatherService.weather.service.weatherApi.WeatherResponseService;
import com.weatherService.weather.service.weatherServer.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private WeatherRepository weatherRepository;

    @Override
    public List<WeatherDto> getWeatherForecastForToday() {
        List<Weather> weatherList = weatherRepository.findFirst3ByOrderByReceivingDateTimeDesc();

        return weatherList.stream()
                .map(WeatherMappers::weatherToWeatherDto)
                .collect(Collectors.toList());
    }
}
