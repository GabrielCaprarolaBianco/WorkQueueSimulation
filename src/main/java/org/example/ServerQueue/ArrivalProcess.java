package org.example.ServerQueue;

import org.example.ServerQueue.QueueCore.Job;
import org.example.Simulators.RNG.ExponentialDistribution;

import java.util.Random;

public class ArrivalProcess {
    //The class responsible for handling the arrival of jobs into the system
    ExponentialDistribution exponentialDistribution;
    public ArrivalProcess(double lambda, double averageTimeBetweenArrivals){
        exponentialDistribution = new ExponentialDistribution(lambda,averageTimeBetweenArrivals, new Random());
    }
    public Job nextJob(){
        return new Job();
    }
    public double nextArrivalTime(double currentTime){
        return currentTime + exponentialDistribution.sample();
    }
}
