package org.example.Simulators;

import org.example.ClockSystem.Clock;
import org.example.QueueCore.Job;
import org.example.QueueCore.Queue;
import org.example.Simulators.RNG.ExponentialDistribution;
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


}
