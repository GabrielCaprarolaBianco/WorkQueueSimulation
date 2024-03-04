package org.example.Simulators;

import org.example.ClockSystem.TimeStamp;

public class Statistics {
    TimeStamp[] timeStamps;



    protected class StatObject{
        float totalWaitTime; //used for average wait time
        int numberOfJobs; //used for both
        TimeStamp[] timeStamps; //used for calculating standard deviations

        protected StatObject(){
            totalWaitTime = 0;
            numberOfJobs = 0;
            timeStamps = new TimeStamp[3000]; //3000 to allows for ample space, will replace in future with better solution
        }

        protected void add(TimeStamp timeStamp){
            


        }
    }

}
