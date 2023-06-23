package com.weatherService.weather.service.weatherApi.impl;

import com.weatherService.weather.dto.mappers.WeatherMappers;
import com.weatherService.weather.dto.weatherApiDto.WeatherApiDto;
import com.weatherService.weather.dto.weatherBitDto.WeatherBitDto;
import com.weatherService.weather.dto.weatherOpenDto.WeatherOpenDto;
import com.weatherService.weather.model.Weather;
import com.weatherService.weather.repository.WeatherRepository;
import com.weatherService.weather.service.weatherApi.WeatherApiPaths;
import com.weatherService.weather.service.weatherApi.WeatherResponseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class WeatherResponseServiceImpl implements WeatherResponseService {
    private WeatherRepository weatherRepository;
    private Weather weather;

    @Override
    @Transactional
    @Scheduled(cron = "0 59 18 * * *", zone="GMT+6")
    public void saveWeatherToDataBaseFromWeatherApi() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WeatherApiDto> weatherApiDtoResponse = restTemplate
                .getForEntity(WeatherApiPaths.WEATHER_API_URI.getUrl(), WeatherApiDto.class);


        if(weatherApiDtoResponse.getBody() != null){
            weather = WeatherMappers.weatherApiDtoToWeather(weatherApiDtoResponse.getBody());
            weatherRepository.save(weather);
        }
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 59 18 * * *", zone="GMT+6")
    public void saveWeatherToDataBaseFromWeatherBitApi() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WeatherBitDto> weatherBitDtoResponse = restTemplate
                .getForEntity(WeatherApiPaths.WEATHER_BIT_URI.getUrl(), WeatherBitDto.class);

        if(weatherBitDtoResponse.getBody() != null){
            weather = WeatherMappers.weatherBitDtoToWeather(weatherBitDtoResponse.getBody());
            weatherRepository.save(weather);
        }
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 59 18 * * *", zone="GMT+6")
    public void saveWeatherToDataBaseFromWeatherOpenApi() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WeatherOpenDto> weatherOpenDtoResponse = restTemplate
                .getForEntity(WeatherApiPaths.OPEN_WEATHER_URI.getUrl(), WeatherOpenDto.class);


        if(weatherOpenDtoResponse.getBody() != null){
            weather = WeatherMappers.weatherOpenDtoToWeather(weatherOpenDtoResponse.getBody());
            weatherRepository.save(weather);
        }
    }
}
