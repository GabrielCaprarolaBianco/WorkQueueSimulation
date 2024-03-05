package org.example.ServerQueue;

import org.example.ServerQueue.QueueCore.Job;
import org.example.ServerQueue.QueueCore.Queue;
import org.example.Simulators.RNG.NormalDistribution;


public class SingleServerQueue {
    Queue queue;
    Job jobInService;
    double nextEndServiceTime;
    NormalDistribution serviceTimeDistribution;

    //Main constructor
    public SingleServerQueue(double meanServiceTime, double standardDeviation, double currentTime){
        serviceTimeDistribution = new NormalDistribution(meanServiceTime, standardDeviation);
        queue = new Queue();
        jobInService = null;
        nextEndServiceTime = currentTime;
    }


    public void add(Job jobToAdd, double currentTime){ //adds job to the service queue
        if(jobInService == null){
            jobInService = jobToAdd;
            jobToAdd.addTimeStamp(currentTime, "Service:MainService"); //name given for service for TimeStamp object
            nextEndServiceTime = serviceTimeDistribution.sample() + currentTime;
        }
        else{
            queue.enqueue(jobToAdd);
            jobToAdd.addTimeStamp(currentTime, "QueueWait:MainQueue");
        }
    }
    public double endServiceTime(){  //returns the next service time for use in simulation
        if(jobInService == null)
            return Double.MAX_VALUE;
        else
            return nextEndServiceTime;
    }
    public Job complete(double currentTime){  //pushes job out of jobInService and replaces it if a job is in the queue
        Job jobToReturn = jobInService;
        jobToReturn.completeTimeStamp(currentTime, "Service:MainService"); //closing out the TimeStamp object
        jobInService = null;
        if(!queue.isQueueEmpty()){  //checks to see if there is a job that can moved into service right away
            jobInService = queue.dequeue();
            jobInService.completeTimeStamp(currentTime, "QueueWait:MainQueue");
            jobInService.addTimeStamp(currentTime,"Service:MainService");
        }
        nextEndServiceTime = serviceTimeDistribution.sample() + currentTime;
        return jobToReturn;
    }
}
