package com.weatherService.weather.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "report")
@Data
public class ConfigReportPath {
    @Value("${report.path}")
    private String reportPath;
}
