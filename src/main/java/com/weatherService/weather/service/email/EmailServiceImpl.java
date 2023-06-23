package com.weatherService.weather.service.email;

import com.weatherService.weather.config.ConfigProperties;
import com.weatherService.weather.model.Weather;
import com.weatherService.weather.repository.WeatherRepository;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService{
    private ConfigProperties configProperties;
    private JavaMailSender javaMailSender;
    private WeatherRepository weatherRepository;
    @Override
    @Scheduled(cron = "0 59 18 * * *", zone="GMT+6")
    public void sendEmail() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(configProperties.getMailUsername());
            mimeMessageHelper.setTo(new InternetAddress(Emails.Yaroslav.getEmail()));
            mimeMessageHelper.setCc(new InternetAddress(Emails.Yaroslav.getEmail()));
            mimeMessageHelper.setSubject("Weather daily report");

            mimeMessageHelper.setText(messageBuilder());

            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String messageBuilder(){
        List<Weather> weatherList = weatherRepository.findFirst3ByOrderByReceivingDateTimeDesc();

        StringBuilder message = new StringBuilder();

        weatherList.forEach(weather -> {
            message.append("Ресурс: ").append(weather.getSource()).append("\n");
            message.append("Город: ").append(weather.getCity()).append("\n");
            message.append("Широта: ").append(weather.getLatitude()).append("\n");
            message.append("Долгота: ").append(weather.getLongitude()).append("\n");
            message.append("Средняя t: ").append(weather.getMiddleTemperature()).append("\n");
            message.append("Ощущаемая t: ").append(weather.getMiddlePerceivedTemperature()).append("\n");
            message.append("Давление мПа: ").append(weather.getPressureMPa()).append("\n");
            message.append("Облачность %: ").append(weather.getCloudinessPercent()).append("\n");
            message.append("Описание : ").append(weather.getWeatherDescription()).append("\n");
            message.append("Скорость ветра").append(weather.getWindSpeed()).append("\n");
            message.append("Направление ветра").append(weather.getWeatherDescription()).append("\n");
            message.append("Дата измерения").append(weather.getObservationDateTime()).append("\n");
            message.append("\n");
        });
        return message.toString();
    }
}
