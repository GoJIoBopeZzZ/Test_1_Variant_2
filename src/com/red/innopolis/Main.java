package com.red.innopolis;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Resource res = new Resource();

        Producer prod = new Producer(res , 100);
        Producer prod2 = new Producer(res , 100);
        Producer prod3 = new Producer(res , 100);

        Consumer con = new Consumer(res , 500);

        con.start();
        prod.start();
        prod2.start();
        prod3.start();
    }
}
