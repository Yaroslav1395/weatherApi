package com.weatherService.weather.dto.weatherOpenDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MainDto {
    private Double temp;
    private Double feels_like;
    private Double pressure;
    private Double humidity;
}
