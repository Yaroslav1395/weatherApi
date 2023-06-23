package com.weatherService.weather.dto.mappers;

import com.weatherService.weather.dto.weatherApiDto.WeatherApiDto;
import com.weatherService.weather.dto.weatherBitDto.WeatherBitDto;
import com.weatherService.weather.dto.weatherDto.WeatherDto;
import com.weatherService.weather.dto.weatherOpenDto.WeatherOpenDto;
import com.weatherService.weather.model.Weather;
import com.weatherService.weather.service.weatherApi.WeatherApiPaths;
import com.weatherService.weather.utils.UnixParser;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class WeatherMappers {
    public static Weather weatherApiDtoToWeather(WeatherApiDto weatherApiDto){
        Weather weather = Weather.builder()
                .city(weatherApiDto.getLocation().getName())
                .latitude(BigDecimal.valueOf(weatherApiDto.getLocation().getLat()))
                .longitude(BigDecimal.valueOf(weatherApiDto.getLocation().getLon()))
                .middleTemperature(BigDecimal.valueOf(weatherApiDto.getCurrent().getTemp_c()))
                .middlePerceivedTemperature(BigDecimal.valueOf(weatherApiDto.getCurrent().getFeelslike_c()))
                .humidityPercent(BigDecimal.valueOf(weatherApiDto.getCurrent().getHumidity()))
                .cloudinessPercent(BigDecimal.valueOf(weatherApiDto.getCurrent().getCloud()))
                .precipitationMm(BigDecimal.valueOf(weatherApiDto.getCurrent().getPrecip_mm()))
                .pressureMPa(BigDecimal.valueOf(weatherApiDto.getCurrent().getPressure_mb()))
                .windSpeed(BigDecimal.valueOf(weatherApiDto.getCurrent().getWind_kph()))
                .windDirectionDegrees(BigDecimal.valueOf(weatherApiDto.getCurrent().getWind_degree()))
                .timeSunset(null)
                .timeSunrise(null)
                .weatherDescription(weatherApiDto.getCurrent().getCondition().getText())
                .source(WeatherApiPaths.WEATHER_API_URI.getUrl())
                .receivingDateTime(Timestamp.valueOf(LocalDateTime.now()))
                .observationDateTime(Timestamp.valueOf(weatherApiDto.getCurrent().getLast_updated()))
                .build();
        System.out.println(weather);
        return weather;
    }

    public static Weather weatherOpenDtoToWeather(WeatherOpenDto weatherOpenDto){
        Weather weather = Weather.builder()
                .city(weatherOpenDto.getName())
                .latitude(BigDecimal.valueOf(weatherOpenDto.getCoord().getLat()))
                .longitude(BigDecimal.valueOf(weatherOpenDto.getCoord().getLon()))
                .middleTemperature(BigDecimal.valueOf(weatherOpenDto.getMain().getTemp() - 273.15))
                .middlePerceivedTemperature(BigDecimal.valueOf(weatherOpenDto.getMain().getFeels_like() - 273.15))
                .humidityPercent(BigDecimal.valueOf(weatherOpenDto.getMain().getHumidity()))
                .cloudinessPercent(BigDecimal.valueOf(weatherOpenDto.getClouds().getAll()))
                .precipitationMm(null)
                .pressureMPa(BigDecimal.valueOf(weatherOpenDto.getMain().getPressure()))
                .windSpeed(BigDecimal.valueOf(weatherOpenDto.getWind().getSpeed()))
                .windDirectionDegrees(BigDecimal.valueOf(weatherOpenDto.getWind().getDeg()))
                .timeSunset(UnixParser.parseUnixToTime(weatherOpenDto.getSys().getSunset()))
                .timeSunrise(UnixParser.parseUnixToTime(weatherOpenDto.getSys().getSunrise()))
                .weatherDescription(weatherOpenDto.getWeather().get(0).getMain())
                .source(WeatherApiPaths.OPEN_WEATHER_URI.getUrl())
                .receivingDateTime(Timestamp.valueOf(LocalDateTime.now()))
                .observationDateTime(UnixParser.parseUnixToTimestamp(weatherOpenDto.getDt()))
                .build();
        System.out.println(weather);
        return weather;
    }
    public static Weather weatherBitDtoToWeather(WeatherBitDto weatherBitDto){
        Weather weather = Weather.builder()
                .city(weatherBitDto.getData().get(0).getCity_name())
                .latitude(BigDecimal.valueOf(weatherBitDto.getData().get(0).getLat()))
                .longitude(BigDecimal.valueOf(weatherBitDto.getData().get(0).getLon()))
                .middleTemperature(BigDecimal.valueOf(weatherBitDto.getData().get(0).getTemp()))
                .middlePerceivedTemperature(BigDecimal.valueOf(weatherBitDto.getData().get(0).getApp_temp()))
                .humidityPercent(BigDecimal.valueOf(weatherBitDto.getData().get(0).getRh()))
                .cloudinessPercent(BigDecimal.valueOf(weatherBitDto.getData().get(0).getClouds()))
                .precipitationMm(BigDecimal.valueOf(weatherBitDto.getData().get(0).getPrecip()))
                .pressureMPa(BigDecimal.valueOf(weatherBitDto.getData().get(0).getPres()))
                .windSpeed(BigDecimal.valueOf(weatherBitDto.getData().get(0).getWind_spd()))
                .windDirectionDegrees(BigDecimal.valueOf(weatherBitDto.getData().get(0).getWind_dir()))
                .timeSunset(Time.valueOf(weatherBitDto.getData().get(0).getSunset()))
                .timeSunrise(Time.valueOf(weatherBitDto.getData().get(0).getSunrise()))
                .weatherDescription(weatherBitDto.getData().get(0).getWeather().getDescription())
                .source(WeatherApiPaths.WEATHER_BIT_URI.getUrl())
                .receivingDateTime(Timestamp.valueOf(LocalDateTime.now()))
                .observationDateTime(Timestamp.valueOf(weatherBitDto.getData().get(0).getOb_time()))
                .build();
        System.out.println(weather);
        return weather;
    }
    public static WeatherDto weatherToWeatherDto(Weather weather){
        System.out.println("----------------------1111111111111111111-------------------");
        System.out.println(weather);
        return WeatherDto.builder()
                .id(weather.getId())
                .windDirectionDegrees(weather.getWindDirectionDegrees().doubleValue())
                .windSpeed(weather.getWindSpeed().doubleValue())
                .timeSunset((weather.getTimeSunset() != null ? weather.getTimeSunset().toLocalTime() : null))
                .timeSunrise(weather.getTimeSunrise() != null ? weather.getTimeSunset().toLocalTime() : null)
                .precipitationMm((weather.getPrecipitationMm() != null ? weather.getPrecipitationMm().doubleValue() : null))
                .receivingDateTime(weather.getReceivingDateTime().toLocalDateTime())
                .observationDateTime(weather.getObservationDateTime().toLocalDateTime())
                .middleTemperature(weather.getMiddleTemperature().doubleValue())
                .city(weather.getCity())
                .latitude(weather.getLatitude().doubleValue())
                .longitude(weather.getLongitude().doubleValue())
                .pressureMPa(weather.getPressureMPa().doubleValue())
                .middlePerceivedTemperature(weather.getMiddlePerceivedTemperature().doubleValue())
                .source(weather.getSource())
                .weatherDescription(weather.getWeatherDescription())
                .cloudinessPercent(weather.getCloudinessPercent().doubleValue())
                .humidityPercent(weather.getHumidityPercent().doubleValue())
                .build();
    }
}
