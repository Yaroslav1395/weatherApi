package com.weatherService.weather.service.scheduledTask;

import com.weatherService.weather.dto.taskDto.TaskDto;
import com.weatherService.weather.service.email.EmailService;
import com.weatherService.weather.service.file.FileService;
import com.weatherService.weather.service.weatherApi.WeatherResponseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
@Data
public class ScheduledTask implements Runnable{
    private TaskDto taskDto;
    private WeatherResponseService weatherResponseService;
    private FileService fileService;
    private EmailService emailService;


    @Override
    public void run() {
        weatherResponseService.saveWeatherToDataBaseFromWeatherApi();
        weatherResponseService.saveWeatherToDataBaseFromWeatherBitApi();
        weatherResponseService.saveWeatherToDataBaseFromWeatherOpenApi();
        try {
            fileService.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        emailService.sendEmail();
    }
}
