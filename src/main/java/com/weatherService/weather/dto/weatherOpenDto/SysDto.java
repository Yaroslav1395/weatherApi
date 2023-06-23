package com.weatherService.weather.dto.weatherOpenDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SysDto {
    private Integer sunrise;
    private Integer sunset;
}
