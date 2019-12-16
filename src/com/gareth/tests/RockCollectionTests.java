package com.gareth.tests;

import com.gareth.RockCollection;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//Author: Gareth Reid

public class RockCollectionTests {
    @Test
    public void joinTest(){
        RockCollection<String> rockArrayList = stringList();
        String joinedList = rockArrayList.join(",");
        Assert.assertEquals("Gareth,John,Reid", joinedList);
    }

    @Test
    public void sortTest(){
        RockCollection<String> rockArrayList = stringListUnordered();
        List<String> sorted = rockArrayList.sort((o1, o2) -> o1.compareTo(o2));
        Assert.assertEquals("Finn", sorted.get(0));
    }

    @Test
    public void minusTest(){
        RockCollection<String> list1 = stringList();
        RockCollection<String> list2 = stringListUnordered();
        List<String> newList = list1.minus(list2);
        Assert.assertEquals(2, newList.size());
    }

    @Test
    public void findTest(){
        RockCollection<String> rockArrayList = stringList();
        String found = rockArrayList.find(str -> str.equals("Gareth"));
        Assert.assertEquals("Gareth", found);
    }

    @Test
    public void findAllTest(){
        RockCollection<String> rockArrayList = stringList();
        List<String> found = rockArrayList.findAll(str -> str.contains("e"));
        Assert.assertEquals(2, found.size());
    }

    @Test
    public void firstTest(){
        RockCollection<String> rockArrayList = stringList();
        String first = rockArrayList.first();
        Assert.assertEquals("Gareth", first);
    }

    @Test
    public void lastTest(){
        RockCollection<String> rockArrayList = stringList();
        String last = rockArrayList.last();
        Assert.assertEquals("Reid", last);
    }

    @Test
    public void reverseTest(){
        RockCollection<String> rockArrayList = stringList();
        List<String> reversed = rockArrayList.reverse();
        Assert.assertEquals("Reid", reversed.get(0));
    }

    @Test
    public void sumTest(){
        RockCollection<Integer> rockArrayList = intList();
        int sumTotal = rockArrayList.sum();
        Assert.assertEquals(39, sumTotal);
    }

    @Test
    public void averageTest(){
        RockCollection<Double> rockArrayList = doubleList();
        Double average = rockArrayList.average();
        Assert.assertEquals((Double)13.0, average);
    }

    @Test
    public void toListTest(){
        RockCollection<String> rockArrayList = stringList();
        List list = rockArrayList.toList();
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void toVectorTest(){
        RockCollection<String> rockArrayList = stringList();
        Vector vector = rockArrayList.toVector();
        Assert.assertEquals(3, vector.size());
    }

    @Test
    public void toArrayTest(){
        RockCollection<String> rockArrayList = stringList();
        Object[] arrayList = rockArrayList.toArray(); //will throw exception if not array
        Assert.assertEquals(3, arrayList.length);
    }

    public RockCollection<String> stringList() {
        RockCollection<String> rockArrayList = new RockCollection<String>();
        rockArrayList.add("Gareth");
        rockArrayList.add("John");
        rockArrayList.add("Reid");
        return rockArrayList;
    }

    public RockCollection<String> stringListUnordered() {
        RockCollection<String> rockArrayList = new RockCollection<String>();
        rockArrayList.add("Miller");
        rockArrayList.add("Finn");
        rockArrayList.add("Reid");
        return rockArrayList;
    }

    public RockCollection<Double> doubleList() {
        RockCollection<Double> rockArrayList = new RockCollection<Double>();
        rockArrayList.add(11.0);
        rockArrayList.add(6.0);
        rockArrayList.add(22.0);
        return rockArrayList;
    }

    public RockCollection<Integer> intList() {
        RockCollection<Integer> rockArrayList = new RockCollection<Integer>();
        rockArrayList.add(11);
        rockArrayList.add(6);
        rockArrayList.add(22);
        return rockArrayList;
    }
}
