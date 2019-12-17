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
        RockCollection<String> rockCollection = stringList();
        String found = rockCollection.find(str -> str.equals("Gareth"));
        Assert.assertEquals("Gareth", found);
    }

    @Test
    public void findAllTest(){
        RockCollection<String> rockCollection = stringList();
        List<String> found = rockCollection.findAll(str -> str.contains("e"));
        Assert.assertEquals(2, found.size());
    }

    @Test
    public void firstTest(){
        RockCollection<String> rockCollection = stringList();
        String first = rockCollection.first();
        Assert.assertEquals("Gareth", first);
    }

    @Test
    public void lastTest(){
        RockCollection<String> rockCollection = stringList();
        String last = rockCollection.last();
        Assert.assertEquals("Reid", last);
    }

    @Test
    public void reverseTest(){
        RockCollection<String> rockCollection = stringList();
        List<String> reversed = rockCollection.reverse();
        Assert.assertEquals("Reid", reversed.get(0));
    }

    @Test
    public void sumTest(){
        RockCollection<Integer> rockCollection = intList();
        int sumTotal = rockCollection.sum();
        Assert.assertEquals(39, sumTotal);
    }

    @Test
    public void averageTest(){
        RockCollection<Double> rockCollection = doubleList();
        Double average = rockCollection.average();
        Assert.assertEquals((Double)13.0, average);
    }

    @Test
    public void toListTest(){
        RockCollection<String> rockCollection = stringList();
        List<String> list = rockCollection.toList();
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void toVectorTest(){
        RockCollection<String> rockCollection = stringVector();
        Vector<String> vector = rockCollection.toVector();
        Assert.assertEquals(3, vector.size());
    }

    @Test
    public void toArrayTest(){
        RockCollection<String> rockCollection = stringList();
        Object[] arrayList = rockCollection.toArray(); //will throw exception if not array
        Assert.assertEquals(3, arrayList.length);
    }

    @Test
    public void toLinkedListTest(){
        RockCollection<String> rockCollection = stringList();
        LinkedList<String> linkedList = rockCollection.toLinkedList();
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void toHashSetTest(){
        RockCollection<String> rockCollection = stringSet();
        HashSet<String> hashSet = rockCollection.toHashSet();
        Assert.assertEquals(3, hashSet.size());
    }

    @Test
    public void toTreeSetTest(){
        RockCollection<String> rockCollection = stringTreeSet();
        TreeSet<String> treeSet = rockCollection.toTreeSet();
        System.out.println(treeSet);
        System.out.println(treeSet.headSet("Miller"));
        System.out.println(treeSet.tailSet("Miller"));
        Assert.assertEquals(6, treeSet.size());
    }

    @Test
    public void toStackTest(){
        RockCollection<String> rockCollection = stringStack();
        Stack<String> stack = rockCollection.toStack();
        Assert.assertEquals(3, stack.size());
    }

    @Test
    public void toQueueTest(){
        RockCollection<String> rockCollection = stringList();
        Queue<String> queue = rockCollection.toQueue();
        Assert.assertEquals(3, queue.size());
    }

    @Test
    public void stackOperateTest(){
        RockCollection<String> rockCollection = stringStack();
        Stack<String> stack = rockCollection.toStack();
        Assert.assertEquals("Reid", stack.pop());
        stack.push("Mr");
        Assert.assertEquals("Mr", stack.pop());
    }

    @Test
    public void queueOperateTest(){
        RockCollection<String> rockCollection = stringList();
        Queue<String> queue = rockCollection.toQueue();
        Assert.assertEquals("Gareth", queue.peek());
        Assert.assertEquals("Gareth", queue.poll());
        queue.add("(Ret.)");
        Assert.assertEquals("John", queue.poll());

    }

    public RockCollection<String> stringList() {
        RockCollection<String> rockCollection = new RockCollection<String>(CollectionImplementation.List);
        rockCollection.add("Gareth");
        rockCollection.add("John");
        rockCollection.add("Reid");
        return rockCollection;
    }

    public RockCollection<String> stringVector() {
        RockCollection<String> rockCollectionVector = new RockCollection<String>(CollectionImplementation.Vector);
        rockCollectionVector.add("Gareth");
        rockCollectionVector.add("John");
        rockCollectionVector.add("Reid");
        return rockCollectionVector;
    }

    public RockCollection<String> stringSet() {
        RockCollection<String> rockArrayList = new RockCollection<String>(CollectionImplementation.Set);
        rockArrayList.add("Gareth");
        rockArrayList.add("John");
        rockArrayList.add("Reid");
        return rockArrayList;
    }

    public RockCollection<String> stringStack() {
        RockCollection<String> rockCollectionStack = new RockCollection<String>(CollectionImplementation.Stack);
        rockCollectionStack.add("Gareth");
        rockCollectionStack.add("John");
        rockCollectionStack.add("Reid");
        return rockCollectionStack;
    }

    public RockCollection<String> stringTreeSet() {
        RockCollection<String> rockCollectionTree = new RockCollection<String>(CollectionImplementation.Tree);
        rockCollectionTree.add("Malcolm");
        rockCollectionTree.add("Carol");
        rockCollectionTree.add("Morgan");
        rockCollectionTree.add("Carl");
        rockCollectionTree.add("Gareth");
        rockCollectionTree.add("Miller");
        return rockCollectionTree;
    }

    public RockCollection<String> stringListUnordered() {
        RockCollection<String> rockCollectionListUnordered = new RockCollection<String>(CollectionImplementation.List);
        rockCollectionListUnordered.add("Miller");
        rockCollectionListUnordered.add("Finn");
        rockCollectionListUnordered.add("Reid");
        return rockCollectionListUnordered;
    }

    public RockCollection<Double> doubleList() {
        RockCollection<Double> rockCollectionDouble = new RockCollection<Double>(CollectionImplementation.List);
        rockCollectionDouble.add(11.0);
        rockCollectionDouble.add(6.0);
        rockCollectionDouble.add(22.0);
        return rockCollectionDouble;
    }

    public RockCollection<Integer> intList() {
        RockCollection<Integer> rockCollectionInteger = new RockCollection<Integer>(CollectionImplementation.List);
        rockCollectionInteger.add(11);
        rockCollectionInteger.add(6);
        rockCollectionInteger.add(22);
        return rockCollectionInteger;
    }
}
