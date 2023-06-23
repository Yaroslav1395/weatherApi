package com.weatherService.weather.service.scheduledTask;



public interface TaskSchedulingService {
     String scheduleATask(String jobId, Runnable tasklet, String cronExpression);
     void removeScheduledTask(String jobId);

}
