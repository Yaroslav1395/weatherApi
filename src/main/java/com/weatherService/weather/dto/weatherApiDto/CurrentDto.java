package com.weatherService.weather.dto.weatherApiDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrentDto {
    private Double temp_c;
    private Double feelslike_c;
    private ConditionDto condition;
    private Double wind_kph;
    private Double wind_degree;
    private Double pressure_mb;
    private Double humidity;
    private Double cloud;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime last_updated;
    private Double precip_mm;

}
