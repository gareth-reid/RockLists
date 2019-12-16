package com.gareth.tests;

import com.gareth.CollectionImplementation;
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
        RockCollection<String> rockArrayList = stringVector();
        Vector vector = rockArrayList.toVector();
        Assert.assertEquals(3, vector.size());
    }

    @Test
    public void toArrayTest(){
        RockCollection<String> rockArrayList = stringList();
        Object[] arrayList = rockArrayList.toArray(); //will throw exception if not array
        Assert.assertEquals(3, arrayList.length);
    }

    @Test
    public void toLinkedListTest(){
        RockCollection<String> rockArrayList = stringList();
        LinkedList linkedList = rockArrayList.toLinkedList();
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void toHashSetTest(){
        RockCollection<String> rockArrayList = stringSet();
        HashSet hashSet = rockArrayList.toHashSet();
        Assert.assertEquals(3, hashSet.size());
    }

    @Test
    public void toTreeSetTest(){
        RockCollection<String> rockArrayList = stringTreeSet();
        TreeSet treeSet = rockArrayList.toTreeSet();
        Assert.assertEquals(3, treeSet.size());
    }

    @Test
    public void toStackTest(){
        RockCollection<String> rockArrayList = stringStack();
        Stack stack = rockArrayList.toStack();
        Assert.assertEquals(3, stack.size());
    }

    public RockCollection<String> stringList() {
        RockCollection<String> rockArrayList = new RockCollection<String>(CollectionImplementation.List);
        rockArrayList.add("Gareth");
        rockArrayList.add("John");
        rockArrayList.add("Reid");
        return rockArrayList;
    }

    public RockCollection<String> stringVector() {
        RockCollection<String> rockArrayList = new RockCollection<String>(CollectionImplementation.Vector);
        rockArrayList.add("Gareth");
        rockArrayList.add("John");
        rockArrayList.add("Reid");
        return rockArrayList;
    }

    public RockCollection<String> stringSet() {
        RockCollection<String> rockArrayList = new RockCollection<String>(CollectionImplementation.Set);
        rockArrayList.add("Gareth");
        rockArrayList.add("John");
        rockArrayList.add("Reid");
        return rockArrayList;
    }

    public RockCollection<String> stringStack() {
        RockCollection<String> rockArrayList = new RockCollection<String>(CollectionImplementation.Stack);
        rockArrayList.add("Gareth");
        rockArrayList.add("John");
        rockArrayList.add("Reid");
        return rockArrayList;
    }

    public RockCollection<String> stringTreeSet() {
        RockCollection<String> rockArrayList = new RockCollection<String>(CollectionImplementation.Tree);
        rockArrayList.add("Gareth");
        rockArrayList.add("John");
        rockArrayList.add("Reid");
        return rockArrayList;
    }

    public RockCollection<String> stringListUnordered() {
        RockCollection<String> rockArrayList = new RockCollection<String>(CollectionImplementation.List);
        rockArrayList.add("Miller");
        rockArrayList.add("Finn");
        rockArrayList.add("Reid");
        return rockArrayList;
    }

    public RockCollection<Double> doubleList() {
        RockCollection<Double> rockArrayList = new RockCollection<Double>(CollectionImplementation.List);
        rockArrayList.add(11.0);
        rockArrayList.add(6.0);
        rockArrayList.add(22.0);
        return rockArrayList;
    }

    public RockCollection<Integer> intList() {
        RockCollection<Integer> rockArrayList = new RockCollection<Integer>(CollectionImplementation.List);
        rockArrayList.add(11);
        rockArrayList.add(6);
        rockArrayList.add(22);
        return rockArrayList;
    }
}
