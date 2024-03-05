package org.example.ServerQueue.QueueCore;

import org.example.ClockSystem.TimeStamp;

import java.util.UUID;

public class Job {
    //Made it UUID instead of Integer, so I won't have to worry about repeating ID values;
    private UUID jobID;
    //TimeStamp array is set to 10 as a default since 10 should be more than enough for any single job
    private TimeStamp[] timeStamp;


    public Job(){
        jobID = UUID.randomUUID();
        timeStamp = new TimeStamp[10];
    }
    public UUID getJobID(){
        return jobID;
    }
    public void addTimeStamp(double currentTime, String locationOfWait){ //adds a new timeStamp object to array list
        int TimeStampIndex = 0;
        int lengthOfArray = timeStamp.length - 1;
        if(timeStamp[lengthOfArray] != null){
            timeStamp = arrayExpansion(timeStamp);    //should be occasionally used, but necessary
        }
        while(timeStamp[TimeStampIndex] != null){
            TimeStampIndex++;
        }
        timeStamp[TimeStampIndex] = new TimeStamp(currentTime, locationOfWait);
    }

    public void completeTimeStamp(double currentTime, String locationOfWait){  //invoked when a job moves between queues/services
        int timeStampIndex = 0;
        while(timeStamp[timeStampIndex] != null){
            if(timeStamp[timeStampIndex].getLocationOfWait() == locationOfWait){
                break;
            }
            else
                timeStampIndex++;
        }
        timeStamp[timeStampIndex].setEndTime(currentTime);
    }

    public TimeStamp[] timeStampDump(){ //This method is to trim any extra space from timeStamp before passing forward
        int timeStampIndex = 0;
        while(timeStamp[timeStampIndex] != null){
            timeStampIndex++;
        }
        TimeStamp[] tempArray = new TimeStamp[timeStampIndex];
        for(int i = 0; i < tempArray.length; i++){
            tempArray[i] = timeStamp[i];
        }
        return tempArray;
    }

    public TimeStamp[] arrayExpansion(TimeStamp[] oldArray){  //expands any timeStamp arrays that need more room
        TimeStamp[] newArray = new TimeStamp[oldArray.length + 10];
        for(int i = 0; i < oldArray.length; i++){
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    @Override
    public String toString(){
            return "Job is named : "+ jobID.toString();
    }

}
