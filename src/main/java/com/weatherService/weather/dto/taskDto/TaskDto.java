package com.weatherService.weather.dto.taskDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TaskDto {
    private Integer id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime cronExpressionTime;
    private String actionType;

}
