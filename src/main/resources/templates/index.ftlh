<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <section class="section-p1">
        <div class="task-form">
            <a href="/weather">Получить свежие данные</a>
            <p></p>
            <form action="/task" method="post">
                <input type="time" id="cronExpressionTime" name="cronExpressionTime" required>
                <input type="hidden" id="actionType" value="task schedule" name="actionType" required>
                <button type="submit">Изменить расписание</button>
            </form>
            <#if message??>
                <p>${message}</p>
            </#if>
        </div>

    </section>
    <section id="cart" class="section-p1">
        <table width="100%">
            <thead>
                <tr>
                    <td>Город</td>
                    <td>Средняя t</td>
                    <td>Ощущаемая t</td>
                    <td>Давление мПа</td>
                    <td>Влажность</td>
                    <td>Облачность</td>
                    <td>Осадки</td>
                    <td>V ветра</td>
                    <td>Описание</td>
                    <td>Закат</td>
                    <td>Восход</td>
                    <td>Время измерения</td>
                </tr>
            </thead>
            <tbody id="tableBody">
                <#if weatherList??>
                    <#list weatherList as weather>
                        <tr id="line">
                            <td>${weather.city}</td>
                            <td>${weather.middleTemperature}</td>
                            <td>${weather.middlePerceivedTemperature}</td>
                            <td>${weather.pressureMPa} мм</td>
                            <td>${weather.humidityPercent} %</td>
                            <td>${weather.cloudinessPercent} %</td>
                            <#if weather.precipitationMm??>
                                <td>${weather.cloudinessPercent}</td>
                            <#else>
                                <td>Данных нет</td>
                            </#if>
                            <td>${weather.windSpeed} км/c</td>
                            <td>${weather.weatherDescription}</td>
                            <#if weather.timeSunset??>
                                <td>${weather.timeSunset}</td>
                            <#else>
                                <td>Данных нет</td>
                            </#if>
                            <#if weather.timeSunrise??>
                                <td>${weather.timeSunrise}</td>
                            <#else>
                                <td>Данных нет</td>
                            </#if>
                            <td>${weather.observationDateTime}</td>
                        </tr>
                    </#list>
                <#else>
                    <div class="empty">
                        <h3>Данных нет</h3>
                    </div>
                </#if>
            </tbody>
        </table>
    </section>
</body>
</html>