package com.red.innopolis;

import java.util.*;

/**
 * Created by _red_ on 12.06.17.
 */
public class Resource {
    private Map<Integer , Integer> map;
    private Integer count;

    public Resource() {
        map = new HashMap<>();
        count = 0;
    }

    public synchronized void produce(Integer number) {
        if (!map.containsKey(number)) map.put(number, 1);
        else map.put(number, map.get(number) + 1);
        count++;
    }

//    public synchronized Integer getSize() {
//        return number.size();
//    }

    public synchronized void printList() {
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
            System.out.println("Key - " + entry.getKey() + " Value - " + entry.getValue());
    }
}
