package org.example.Simulators;

import org.example.ClockSystem.Clock;
import org.example.ServerQueue.ArrivalProcess;
import org.example.ServerQueue.QueueCore.Queue;
import org.example.ServerQueue.SingleServerQueue;


public class TimeSimulator {
    //This class is a version of the simulation that is driven by time passed

    SingleServerQueue serverQueue;
    //the clock object that is responsible for keeping and returning the current time
    Clock globalClock;
    //the process for producing jobs
    ArrivalProcess arrivalProcess;
    //this Queue is used to capture all jobs that have finish service for statistical calculations
    Queue completedJobQueue;

    //the main constructor
    public TimeSimulator(double meanServiceTime, double standardDeviation, double lambda, double averageTimeBetweenArrivals){
        serverQueue = new SingleServerQueue( meanServiceTime, standardDeviation, 0);
        globalClock = new Clock();
        arrivalProcess = new ArrivalProcess(lambda, averageTimeBetweenArrivals);
        completedJobQueue = new Queue();
    }

    public void run(double runTime){ //Method responsible for running the simulation
        double nextArrivalTime;
        double nextServiceTime;
        serverQueue.add(arrivalProcess.nextJob(), globalClock.whatTimeIsIt()); //adds the job that would signify the start of the time keeping
        while(runTime > globalClock.whatTimeIsIt()){
            nextArrivalTime = arrivalProcess.nextArrivalTime(globalClock.whatTimeIsIt());
            nextServiceTime = serverQueue.endServiceTime();
            if(nextServiceTime <= nextArrivalTime){ //logic flow for choosing which event happens first based on the nextTimes given above
                completedJobQueue.enqueue(serverQueue.complete(nextServiceTime));
                globalClock.setGlobalClock(nextServiceTime);
            }
            else{
                serverQueue.add(arrivalProcess.nextJob(), nextArrivalTime);
                globalClock.setGlobalClock(nextArrivalTime);
            }
        }//while loop
        Statistics statistics = new Statistics();
        statistics.calculate(completedJobQueue);
    }//run
}//TimeSimulator
