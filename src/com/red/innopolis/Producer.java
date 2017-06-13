package com.red.innopolis;

import java.util.Random;

/**
 * Created by _red_ on 12.06.17.
 */
public class Producer extends Thread {
    static volatile boolean stopThread = false;
    private int produceCounter;
    private Resource resource;
    private int timeLimit;

    public Producer(Resource resource, int timeLimit) {
        this.resource = resource;
        this.produceCounter = 0;
        this.timeLimit = timeLimit;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        while (!stopThread) {
            Integer test = random.nextInt(100);
            resource.produce(test);
//            resource.produce(test);
//            if (resource.getSize() >= 100) break;
////            wakeUp();
//            this.produceCounter++;
            System.out.print(test + " ");
            try {
                Thread.sleep(timeLimit);
            } catch (InterruptedException e1) {
                System.out.println("Consumer thread is interrupted!!!");
            }
        }

        Consumer.stopThread = true;
//        wakeUp();

//        resource.printList();
    }

    private synchronized void wakeUp() {
        this.notifyAll();
    }
}
