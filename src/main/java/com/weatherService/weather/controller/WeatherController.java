package com.weatherService.weather.controller;


import com.weatherService.weather.dto.weatherDto.WeatherDto;
import com.weatherService.weather.service.weatherServer.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/weather")
@AllArgsConstructor
public class WeatherController {
    private WeatherService weatherService;

    @GetMapping
    public String getWeather(Model model) throws IOException {
        List<WeatherDto> weatherDtoList = weatherService.getWeatherForecastForToday();
        if(weatherDtoList != null && !weatherDtoList.isEmpty()){
            model.addAttribute("weatherList", weatherDtoList);
        }
        return "index";
    }
}
