package org.example.Simulators.RNG;

import java.util.Random;

public class NormalDistribution {
    private double meanServiceTime;
    private Random random;
    private double standardDeviation;
    public NormalDistribution(double meanServiceTime, double standardDeviation){
        this.meanServiceTime = meanServiceTime;
        this.standardDeviation = standardDeviation;
        random = new Random();
    }
    public double sample(){
        return (standardDeviation* random.nextDouble(-2,2)) + meanServiceTime;
    }
}
