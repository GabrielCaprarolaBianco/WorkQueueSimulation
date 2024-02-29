package org.example.Simulators;

import org.example.ClockSystem.Clock;
import org.example.ServerQueue.ArrivalProcess;
import org.example.ServerQueue.QueueCore.Queue;
import org.example.ServerQueue.SingleServerQueue;


public class TimeSimulator {
    SingleServerQueue serverQueue;
    Clock globalClock;
    ArrivalProcess arrivalProcess;
    Queue completedJobQueue;
    public TimeSimulator(double meanServiceTime, double standardDeviation, double lambda, double averageTimeBetweenArrivals){
        serverQueue = new SingleServerQueue( meanServiceTime, standardDeviation, 0);
        globalClock = new Clock();
        arrivalProcess = new ArrivalProcess(lambda, averageTimeBetweenArrivals);
        completedJobQueue = new Queue();
    }

    public void run(double runTime){
        double nextArrivalTime;
        double nextServiceTime;
        serverQueue.add(arrivalProcess.nextJob(), globalClock.whatTimeIsIt());
        while(runTime > globalClock.whatTimeIsIt()){
            nextArrivalTime = arrivalProcess.nextArrivalTime(globalClock.whatTimeIsIt());
            nextServiceTime = serverQueue.endServiceTime();
            if(nextServiceTime >= nextArrivalTime){

            }

        }
    }
}
