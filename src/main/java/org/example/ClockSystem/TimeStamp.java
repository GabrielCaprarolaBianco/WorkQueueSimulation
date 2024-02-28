package org.example.ClockSystem;

import org.example.ClockSystem.Clock;

public class TimeStamp extends Clock {
    private double startTime, endTime, totalWaitTime;
    public TimeStamp(long startTime){
        this.startTime = startTime;
        endTime = 0;
        totalWaitTime = 0;
    }
    public void setEndTime(long endTime){
        this.endTime = endTime;
        setTotalWaitTime();
    }
    protected void setTotalWaitTime(){
        totalWaitTime = endTime - startTime;
    }
    public double getTotalWaitTime(){
        return totalWaitTime;
    }
}
