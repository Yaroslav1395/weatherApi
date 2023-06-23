package com.weatherService.weather.dto.weatherOpenDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherOpenDto {
    private CoordDto coord;
    private List<WeatherDto> weather;
    private MainDto main;
    private WindDto wind;
    private CloudsDto clouds;
    private Integer dt;
    private SysDto sys;
    private String name;

}
