package com.weatherService.weather.dto.weatherApiDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherApiDto {
    private LocationDto location;
    private CurrentDto current;
}
