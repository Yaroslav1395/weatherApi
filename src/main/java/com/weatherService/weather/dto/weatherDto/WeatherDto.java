package com.weatherService.weather.dto.weatherDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto {
    private Integer id;
    private LocalDateTime receivingDateTime;
    private String city;
    private Double latitude;
    private Double longitude;
    private LocalTime timeSunrise;
    private LocalTime timeSunset;
    private Double middleTemperature;
    private Double middlePerceivedTemperature;
    private Double pressureMPa;
    private Double humidityPercent;
    private String weatherDescription;
    private Double windSpeed;
    private Double windDirectionDegrees;
    private Double cloudinessPercent;
    private Double precipitationMm;
    private String source;
    private LocalDateTime observationDateTime;
}
