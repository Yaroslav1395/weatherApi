package com.weatherService.weather.dto.weatherOpenDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WindDto {
    private Double speed;
    private Double deg;
}
