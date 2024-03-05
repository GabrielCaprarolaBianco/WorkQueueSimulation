package org.example;

import org.example.Simulators.TimeSimulator;

public class Main {
    public static void main(String[] args) {
        //The TimeSimulator class requires 4 values to be entered into it
        //Those values are meanServiceTime:double , standardDeviationForService:double , lambdaForArrivals:double , averageTimeBetweenArrivals:double
        //The run class for timeSimulator takes in a double value that equals the time the simulation should run for
        TimeSimulator timeSimulator = new TimeSimulator(3,1,.125,3);
        timeSimulator.run(10000);
    }
}