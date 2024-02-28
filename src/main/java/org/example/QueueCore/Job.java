package org.example.QueueCore;

import org.example.ClockSystem.TimeStamp;

import java.util.UUID;

public class Job {
    //Made it UUID instead of Integer, so I won't have to worry about repeating ID values;
    private UUID jobID;
    private TimeStamp timeStamp;
    //Job class will have a value that will be equal to null. That is currently set to a UUID with all 0 values
    private UUID nullValue = UUID.fromString("00000000-0000-0000-0000-000000000000");

    public Job(long currentTime){
        jobID = UUID.randomUUID();
        timeStamp = new TimeStamp(currentTime);
    }

    //Using a boolean value input ensures only when a null value is needed that it is produced
    public Job(boolean nullValueFlag){
        jobID = nullValue;
        timeStamp = null;
    }
    public UUID getJobID(){
        return jobID;
    }
    @Override
    public String toString(){
        if(jobID == nullValue){  //Ensures no null values are output in toString
            return "Job is empty";
        }
        else
            return "Job is named : "+ jobID.toString();
    }

}
