package com.gareth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

//Author: Gareth Reid
public class Threading implements Runnable  {
    public static ArrayList<Integer> List;
    public static ArrayList<Integer> postList;

    public Boolean RunWithArrayLists(){
        ArrayList<Integer> list = new ArrayList(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}));
        ArrayList<Integer> postList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            postList.add(list.get(i) + 200);
        }

        try {
            for (int i = 0; i < list.size(); i++) {
                if (postList.get(i) != list.get(i) + 200) {
                    throw new Exception("Thread race error");
                }
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public void run() {
        RunWithArrayLists();
        Thread thread = Thread.currentThread();

    }
}
