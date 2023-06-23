package com.weatherService.weather.dto.weatherBitDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DataDto {
    private Double wind_dir;
    private Double wind_spd;
    private String city_name;
    private LocalTime sunrise;
    private LocalTime sunset;
    private Double lat;
    private Double lon;
    private Double temp;
    private Double app_temp;
    private Double pres;
    private Double rh;
    private WeatherDto weather;
    private Double clouds;
    private Double precip;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime ob_time;
}
