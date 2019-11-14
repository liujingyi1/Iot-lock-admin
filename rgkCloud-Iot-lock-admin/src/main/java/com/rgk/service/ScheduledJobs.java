package com.rgk.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJobs {
    public final static long ONE_Minute =  60 * 1000;

    public final static long ONE_Day =  60 * 1000 * 60 * 24;
    
    @Scheduled(fixedRate=ONE_Day)
    public void fixedRateJob(){
    	
    }
}
