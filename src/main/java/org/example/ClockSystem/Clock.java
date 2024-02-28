package org.example.ClockSystem;

public class Clock {

    private ClockObject globalClock = new ClockObject();

    public void addTime(long timeToAdd){
        globalClock.addTime(timeToAdd);
    }
    public double whatTimeIsIt(){
        return globalClock.whatTimeIsIt();
    }

    //this class is the private side of the Clock system that is constantly updated
    protected class ClockObject{
        private double currentTime;

        protected ClockObject(){
            currentTime = 0;
        }

        public void addTime(long timeToAdd){
            currentTime += timeToAdd;
        }
        public double whatTimeIsIt(){
            return currentTime;
        }

    }//ClockObject
}//Clock
