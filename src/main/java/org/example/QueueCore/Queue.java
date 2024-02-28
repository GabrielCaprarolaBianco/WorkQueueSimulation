package org.example.QueueCore;

public class Queue {
    private QueueObject head, tail;
    public Queue(){
        head = null;
        tail = null;
    }


    public void enqueue(Job job){
        if(head == null){                 //If head is null that means queue is empty, so tail and head need to be
            head = new QueueObject(job);  //set to the first object in queue
            tail = head;
        }
        else{
            tail.nextQueue = new QueueObject(job);
            tail = tail.nextQueue;
        }
    }

    public Job dequeue(){
        Job returnJob;
        if(head == null){
            //Job with an assigned UUID of 'null' will act as a null value
            //This is done to dodge issues with null values being passed to methods calling for a job
            //The value for a null Job is a UUID with all values set to "0"
            return new Job(true);
        }
        if(head.getJob() == tail.getJob()){
            returnJob = head.getJob();
            head = null;
            tail = null;
            return returnJob;
        }
        returnJob = head.getJob();
        head = head.nextQueue;
        return returnJob;
    }

    public boolean isQueueEmpty(){
        if(head == null)
            return true;
        else
            return false;
    }


    protected int queueLength(){
        //queueSize is set to one because the while loop will end before adding the tail item to count
        int queueSize = 1;
        QueueObject index = head;
        while(index.getNextQueue() != null){
            queueSize++;
            index = index.nextQueue;
        }
        return queueSize;
    }

    protected class QueueObject{
        private Job job;
        private QueueObject nextQueue;
        public QueueObject(Job job){
            this.job = job;
            nextQueue = null;
        }
        public Job getJob(){
            return job;
        }
        public QueueObject getNextQueue(){
            return nextQueue;
        }
    }
}
