package org.example.ClockSystem;

public class Clock {

    private ClockObject globalClock = new ClockObject();

    public void addTime(double timeToAdd){
        globalClock.addTime(timeToAdd);
    }
    public void setGlobalClock(double newTime){ //class added for proper encapsulation
        globalClock.setCurrentTime(newTime);
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

        public void addTime(double timeToAdd){
            currentTime += timeToAdd;
        }
        public void setCurrentTime(double newTime){
            currentTime = newTime;
        }
        public double whatTimeIsIt(){
            return currentTime;
        }

    }//ClockObject
}//Clock
