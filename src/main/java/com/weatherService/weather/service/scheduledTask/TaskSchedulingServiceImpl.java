package com.weatherService.weather.service.scheduledTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ScheduledFuture;

@Service
public class TaskSchedulingServiceImpl implements TaskSchedulingService{
    @Autowired
    private TaskScheduler taskScheduler;

    Map<String, ScheduledFuture<?>> jobsMap = new HashMap<>();
    @Override
    public String scheduleATask(String jobId, Runnable tasklet, String cronExpression) {
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(tasklet, new CronTrigger(cronExpression, TimeZone.getTimeZone("GMT+6")));
        jobsMap.put(jobId, scheduledTask);
        if(jobsMap.get(jobId) != null){
            return "Задача создана";
        }
        return "Задача не создана";
    }
    @Override
    public void removeScheduledTask(String jobId) {
        ScheduledFuture<?> scheduledTask = jobsMap.get(jobId);
        if(scheduledTask != null) {
            scheduledTask.cancel(true);
            jobsMap.put(jobId, null);
        }
    }
}

