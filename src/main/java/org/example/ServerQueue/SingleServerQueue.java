package org.example.ServerQueue;

import org.example.ServerQueue.QueueCore.Job;
import org.example.ServerQueue.QueueCore.Queue;
import org.example.Simulators.RNG.NormalDistribution;


public class SingleServerQueue {
    Queue queue;
    Job jobInService;
    double nextEndServiceTime;
    NormalDistribution serviceTimeDistribution;

    public SingleServerQueue(double meanServiceTime, double standardDeviation, double currentTime){
        serviceTimeDistribution = new NormalDistribution(meanServiceTime, standardDeviation);
        queue = new Queue();
        jobInService = null;
        nextEndServiceTime = currentTime;
    }
    public void add(Job jobToAdd, double currentTime){
        if(jobInService == null){
            jobInService = jobToAdd;
            jobToAdd.addTimeStamp(currentTime, "Service:MainService");
            nextEndServiceTime = serviceTimeDistribution.sample() + currentTime;
        }
        else{
            queue.enqueue(jobToAdd);
            jobToAdd.addTimeStamp(currentTime, "QueueWait:MainQueue");
        }
    }
    public double endServiceTime(){
        if(jobInService == null)
            return Double.MAX_VALUE;
        else
            return nextEndServiceTime;
    }
    public Job complete(double currentTime){
        Job jobToReturn = jobInService;
        jobToReturn.completeTimeStamp(currentTime, "Service:MainService");
        if(!queue.isQueueEmpty()){
            jobInService = queue.dequeue();
            jobInService.completeTimeStamp(currentTime, "QueueWait:MainQueue");
            jobInService.addTimeStamp(currentTime,"Service:MainService");
            nextEndServiceTime = serviceTimeDistribution.sample() + currentTime;
        }
        return jobToReturn;
    }
}
