package com.weatherService.weather.service.file;

import com.weatherService.weather.config.ConfigReportPath;
import com.weatherService.weather.model.Weather;
import com.weatherService.weather.repository.WeatherRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService{
    private WeatherRepository weatherRepository;
    private ConfigReportPath configReportPath;
    @Override
    @Scheduled(cron = "0 59 18 * * *", zone="GMT+6")
    public void saveFile() throws IOException {

        XWPFDocument doc = createDocument();

        String fileName = "weatherReport.docx";

        File f = new File(configReportPath.getReportPath());
        if(!f.exists()){
            System.out.println("Create folder");
            f.mkdir();
        }

        FileOutputStream out = new FileOutputStream(configReportPath.getReportPath() + fileName);
        doc.write(out);
        doc.close();
        out.close();
    }

    private XWPFDocument createDocument(){
        List<Weather> weatherList = weatherRepository.findFirst3ByOrderByReceivingDateTimeDesc();
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph tmpParagraph = doc.createParagraph();
        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setText("Отчет о погоде на " + LocalDateTime.now());

        XWPFTable table = doc.createTable();
        XWPFTableRow row1 = table.getRow(0);
        row1.getCell(0).setText("Город");
        row1.addNewTableCell().setText("Широта");
        row1.addNewTableCell().setText("Долгота");
        row1.addNewTableCell().setText("Средняя, t");
        row1.addNewTableCell().setText("Ощущаемая, t");
        row1.addNewTableCell().setText("Давление, мПа");
        row1.addNewTableCell().setText("Влажность, %");
        row1.addNewTableCell().setText("Облачность, %");
        row1.addNewTableCell().setText("Осадки, мм");


        XWPFTableRow row2 = table.createRow();
        row2.getCell(0).setText(weatherList.get(0).getCity());
        row2.getCell(1).setText(weatherList.get(0).getLatitude().toString());
        row2.getCell(2).setText(weatherList.get(0).getLongitude().toString());
        row2.getCell(3).setText(weatherList.get(0).getMiddleTemperature().toString());
        row2.getCell(4).setText(weatherList.get(0).getMiddlePerceivedTemperature().toString());
        row2.getCell(5).setText(weatherList.get(0).getPressureMPa().toString());
        row2.getCell(6).setText(weatherList.get(0).getHumidityPercent().toString());
        row2.getCell(7).setText(weatherList.get(0).getCloudinessPercent().toString());
        row2.getCell(8).setText(
                weatherList.get(0).getPrecipitationMm() != null ?
                        weatherList.get(0).getPrecipitationMm().toString() : "Данных нет");

        XWPFTableRow row3 = table.createRow();
        row3.getCell(0).setText(weatherList.get(1).getCity());
        row3.getCell(1).setText(weatherList.get(1).getLatitude().toString());
        row3.getCell(2).setText(weatherList.get(1).getLongitude().toString());
        row3.getCell(3).setText(weatherList.get(1).getMiddleTemperature().toString());
        row3.getCell(4).setText(weatherList.get(1).getMiddlePerceivedTemperature().toString());
        row3.getCell(5).setText(weatherList.get(1).getPressureMPa().toString());
        row3.getCell(6).setText(weatherList.get(1).getHumidityPercent().toString());
        row3.getCell(7).setText(weatherList.get(1).getCloudinessPercent().toString());
        row3.getCell(8).setText(
                weatherList.get(1).getPrecipitationMm() != null ?
                        weatherList.get(1).getPrecipitationMm().toString() : "Данных нет");

        XWPFTableRow row4 = table.createRow();
        row4.getCell(0).setText(weatherList.get(2).getCity());
        row4.getCell(1).setText(weatherList.get(2).getLatitude().toString());
        row4.getCell(2).setText(weatherList.get(2).getLongitude().toString());
        row4.getCell(3).setText(weatherList.get(2).getMiddleTemperature().toString());
        row4.getCell(4).setText(weatherList.get(2).getMiddlePerceivedTemperature().toString());
        row4.getCell(5).setText(weatherList.get(2).getPressureMPa().toString());
        row4.getCell(6).setText(weatherList.get(2).getHumidityPercent().toString());
        row4.getCell(7).setText(weatherList.get(2).getCloudinessPercent().toString());
        row4.getCell(8).setText(weatherList.get(2).getPrecipitationMm() != null ?
                weatherList.get(2).getPrecipitationMm().toString() : "Данных нет");

        doc.createParagraph().createRun().addBreak();

        XWPFTable table2 = doc.createTable();
        XWPFTableRow row5 = table2.getRow(0);
        row5.getCell(0).setText("Город");
        row5.addNewTableCell().setText("Закат t");
        row5.addNewTableCell().setText("Восход t");
        row5.addNewTableCell().setText("Скорость ветра, км/с");
        row5.addNewTableCell().setText("Направление ветра, градусы");
        row5.addNewTableCell().setText("Описание");
        row5.addNewTableCell().setText("Время измерения");


        XWPFTableRow row6 = table2.createRow();
        row6.getCell(0).setText(weatherList.get(0).getCity());
        row6.getCell(1).setText(weatherList.get(0).getTimeSunset() != null ? weatherList.get(0).getTimeSunset().toString() : "Данных нет");
        row6.getCell(2).setText(weatherList.get(0).getTimeSunrise() != null ? weatherList.get(0).getTimeSunrise().toString() : "Данных нет");
        row6.getCell(3).setText(weatherList.get(0).getWindSpeed().toString());
        row6.getCell(4).setText(weatherList.get(0).getWindDirectionDegrees().toString());
        row6.getCell(5).setText(weatherList.get(0).getWeatherDescription());
        row6.getCell(6).setText(weatherList.get(0).getObservationDateTime().toString());

        XWPFTableRow row7 = table2.createRow();
        row7.getCell(0).setText(weatherList.get(1).getCity());
        row7.getCell(1).setText(weatherList.get(1).getTimeSunset() != null ? weatherList.get(1).getTimeSunset().toString() : "Данных нет");
        row7.getCell(2).setText(weatherList.get(1).getTimeSunrise() != null ? weatherList.get(1).getTimeSunrise().toString() : "Данных нет");
        row7.getCell(3).setText(weatherList.get(1).getWindSpeed().toString());
        row7.getCell(4).setText(weatherList.get(1).getWindDirectionDegrees().toString());
        row7.getCell(5).setText(weatherList.get(1).getWeatherDescription());
        row7.getCell(6).setText(weatherList.get(1).getObservationDateTime().toString());

        XWPFTableRow row8 = table2.createRow();
        row8.getCell(0).setText(weatherList.get(2).getCity());
        row8.getCell(1).setText(weatherList.get(2).getTimeSunset() != null ? weatherList.get(2).getTimeSunset().toString() : "Данных нет");
        row8.getCell(2).setText(weatherList.get(2).getTimeSunrise() != null ? weatherList.get(2).getTimeSunrise().toString() : "Данных нет");
        row8.getCell(3).setText(weatherList.get(2).getWindSpeed().toString());
        row8.getCell(4).setText(weatherList.get(2).getWindDirectionDegrees().toString());
        row8.getCell(5).setText(weatherList.get(2).getWeatherDescription());
        row8.getCell(6).setText(weatherList.get(2).getObservationDateTime().toString());
        return doc;
    }
}
