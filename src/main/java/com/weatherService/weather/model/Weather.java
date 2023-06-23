package com.weatherService.weather.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
@Component
@Entity
@Data
@Builder
@Table(name = "weathers")
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "receiving_date_time")
    @NotNull(message = "Receiving date time can not be null")
    private Timestamp receivingDateTime;
    @NotNull(message = "Receiving date time can not be null")
    @Size(min = 5, max = 40, message = "Size of city name must be between 5 and 40 symbol")
    private String city;
    @NotNull(message = "Latitude can not be null")
    @DecimalMax(value = "100.0", message = "Latitude must be smaller then 100")
    @DecimalMin(value = "-100.0", message = "Latitude must be bigger then -100")
    private BigDecimal latitude;
    @NotNull(message = "Longitude can not be null")
    @DecimalMax(value = "100.0", message = "Longitude must be smaller then 100")
    @DecimalMin(value = "-100.0", message = "Longitude must be bigger then -100")
    private BigDecimal longitude;
    @Column(name = "time_sunrise")
    //@NotNull(message = "Sunrise time can not be null")
    private Time timeSunrise;
    @Column(name = "time_sunset")
    //@NotNull(message = "Sunset time can not be null")
    private Time timeSunset;
    @Column(name = "middle_temperature")
    @NotNull(message = "Middle temperature can not be null")
    @DecimalMax(value = "100.0", message = "Middle temperature must be smaller then 100")
    //@Digits(integer = 100, fraction = 2, message = "Middle temperature must contain 2 symbols after point")
    private BigDecimal middleTemperature;
    @Column(name = "middle_Perceived_temperature")
    @NotNull(message = "Middle temperature can not be null")
    @DecimalMax(value = "100.0", message = "Middle temperature must be smaller then 100")
    //@Digits(integer = 100, fraction = 2, message = "Middle temperature must contain 2 symbols after point")
    private BigDecimal middlePerceivedTemperature;
    @Column(name = "pressure_m_pa")
    @NotNull(message = "Middle temperature can not be null")
    @DecimalMax(value = "1500.0", message = "Pressure mPa must be smaller then 1500")
    //@Digits(integer = 1500, fraction = 2, message = "Pressure mPa must contain 2 symbols after point")
    private BigDecimal pressureMPa;
    @Column(name = "humidity_percent")
    @NotNull(message = "Humidity percent can not be null")
    @DecimalMax(value = "100.0", message = "Humidity percent must be smaller then 100")
    //@Digits(integer = 100, fraction = 2, message = "Humidity percent must contain 2 symbols after point")
    private BigDecimal humidityPercent;
    @Column(name = "weather_description")
    @NotNull(message = "Weather description can not be null")
    @Length(max = 50, message = "Description length must be smaller then 50")
    private String weatherDescription;
    @Column(name = "wind_speed")
    @NotNull(message = "Wind speed can not be null")
    @DecimalMax(value = "600.0", message = "Wind speed must be smaller then 600")
    //@Digits(integer = 600, fraction = 2, message = "Wind speed must contain 2 symbols after point")
    private BigDecimal windSpeed;
    @Column(name = "wind_direction_degrees")
    @NotNull(message = "Wind direction degrees can not be null")
    @DecimalMax(value = "360.0", message = "Wind direction degrees must be smaller then 100")
    //@Digits(integer = 100, fraction = 2, message = "Wind direction degrees must contain 2 symbols after point")
    private BigDecimal windDirectionDegrees;
    @Column(name = "cloudiness_percent")
    @NotNull(message = "Cloudiness percent can not be null")
    @DecimalMax(value = "100.0", message = "Cloudiness percent must be smaller then 100")
    //@Digits(integer = 100, fraction = 2, message = "Cloudiness percent must contain 2 symbols after point")
    private BigDecimal cloudinessPercent;
    @Column(name = "precipitation_mm")
    //@NotNull(message = "Precipitation mm can not be null")
    @DecimalMax(value = "2000.0", message = "Precipitation mm must be smaller then 2000")
    //@Digits(integer = 2000, fraction = 2, message = "Precipitation mm must contain 2 symbols after point")
    private BigDecimal precipitationMm;
    @NotNull(message = "Source description can not be null")
    @Length(max = 100, message = "Source length must be smaller then 100")
    private String source;
    @Column(name = "observation_date_time")
    @NotNull(message = "Source description can not be null")
    private Timestamp observationDateTime;
}
