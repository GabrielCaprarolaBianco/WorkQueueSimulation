package org.example;

import org.example.Simulators.TimeSimulator;

public class Main {
    public static void main(String[] args) {
        TimeSimulator timeSimulator = new TimeSimulator(3,1,.5,3);
        timeSimulator.run(10000);
    }
}