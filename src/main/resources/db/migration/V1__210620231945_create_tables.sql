USE weather;
CREATE TABLE `weathers` (
  `cloudiness_percent` decimal(38,2) NOT NULL,
  `humidity_percent` decimal(38,2) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `latitude` decimal(38,2) NOT NULL,
  `longitude` decimal(38,2) NOT NULL,
  `middle_perceived_temperature` decimal(38,2) NOT NULL,
  `middle_temperature` decimal(38,2) NOT NULL,
  `precipitation_mm` decimal(38,2) DEFAULT NULL,
  `pressure_m_pa` decimal(38,2) NOT NULL,
  `time_sunrise` time(6) DEFAULT NULL,
  `time_sunset` time(6) DEFAULT NULL,
  `wind_direction_degrees` decimal(38,2) NOT NULL,
  `wind_speed` decimal(38,2) NOT NULL,
  `observation_date_time` datetime(6) NOT NULL,
  `receiving_date_time` datetime(6) NOT NULL,
  `city` varchar(40) NOT NULL,
  `weather_description` varchar(50) NOT NULL,
  `source` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);