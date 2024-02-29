package org.example.ServerQueue.QueueCore;

public class QueueUnitTests {
    public void mainTest( int testLength){
        Queue testQueue = new Queue();
        enqueueTest(testQueue, testLength, "");
        dequeueTest(testQueue,testLength);
    }

    public Queue enqueueTest(Queue testQueue,int testLength, String locationOfWait){
        for(int i = 0; i < testLength; i++){
            //testQueue.enqueue(new Job(2, locationOfWait));
        }
        //System.out.println(testQueue.queueLength());
        return testQueue;
    }
    public Queue dequeueTest(Queue testQueue,int testLength){
        for(int i = 0; i < testLength; i++){
            System.out.println(testQueue.dequeue().toString());
        }
        return testQueue;
    }

}
