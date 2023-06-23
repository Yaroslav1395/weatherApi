package com.weatherService.weather.controller;

import com.weatherService.weather.dto.taskDto.TaskDto;
import com.weatherService.weather.service.scheduledTask.ScheduledTask;
import com.weatherService.weather.service.scheduledTask.TaskSchedulingService;
import com.weatherService.weather.service.weatherServer.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {
    private TaskSchedulingService taskSchedulingService;
    private ScheduledTask scheduledTask;
    private WeatherService weatherService;

    @PostMapping
    public String newScheduledTask(@ModelAttribute TaskDto taskDto, Model model){

        if(taskDto != null){

            String cronExpression = "0 " +
                    taskDto.getCronExpressionTime().getMinute() + " " +
                    taskDto.getCronExpressionTime().getHour() + " * * *";

            scheduledTask.setTaskDto(taskDto);
            String message = taskSchedulingService.scheduleATask(UUID.randomUUID().toString(), scheduledTask, cronExpression);
            model.addAttribute("message", message);

        }
        model.addAttribute("weatherList", weatherService.getWeatherForecastForToday());
        return "index";
    }
}
