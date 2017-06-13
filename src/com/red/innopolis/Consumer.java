package com.red.innopolis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by _red_ on 12.06.17.
 */

public class Consumer extends Thread{
    static volatile boolean stopThread = false;
    private Resource resource;
    private Random random;
    private List<Integer> list;
    private int interval;

    public Consumer (Resource resource, int interval) {
        this.resource = resource;
        list = new ArrayList<>();
        this.interval = interval;
    }

    public void run() {
        try {
            while (!stopThread) {
                try {
                    Thread.sleep(this.interval);
                } catch (InterruptedException ex) {
                    System.out.println("Всё Очень Плохо!!!");
                }

                resource.printList();
//                System.out.println("Uniq elements - " + resource.getSize());
//                if (resource.getSize() > 1) {
//                    list.add(resource.getAndRemoveResource());
//                    System.out.println("Consumer - " + Thread.currentThread().getName() + " : remove - " + list.get(list.size() - 1));
//                    } else shutDown();
                }
            } finally {
            System.out.println("Поток " + Thread.currentThread().getName() +  " завершили работу!");
        }
    }

    private synchronized void shutDown() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
