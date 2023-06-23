package com.weatherService.weather.repository;

import com.weatherService.weather.model.Weather;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherRepository extends CrudRepository<Weather, Integer> {
    public List<Weather> findFirst3ByOrderByReceivingDateTimeDesc();
}
