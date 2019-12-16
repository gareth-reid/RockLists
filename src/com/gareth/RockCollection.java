package com.gareth;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RockCollection<T extends Comparable<T>> implements Collection<T> {
    private Collection<T> _list;
    public RockCollection(CollectionImplementation implementation){
        switch (implementation) {
            case List:
                _list = new LinkedList<>();
                break;
            case Vector:
                _list = new Vector<>();
                break;
            case Set:
                _list = new HashSet<>();
                break;
            case Map:
                //_list = new HashMap<>();
                break;
            case Tree:
                _list = new TreeSet<>();
                break;
            case Queue:
                //_list = new ArrayQueue;
                break;
            case Stack:
                _list = new Stack<>();
                break;
        }
    }

    //###########Custom extension methods###########
    public T find(Predicate<T> predicate) {
        return _list.stream()
                .filter(predicate)
                .findFirst()
                .get();
    }

    public List<T> findAll(Predicate<T> predicate) {
        return _list.stream()
                .filter(predicate)
                .collect(Collectors.<T>toList());
    }

    public String join(String joiner) {
        StringBuilder aggregate = new StringBuilder("");
        _list.forEach( item ->
            aggregate.append(item.toString() + joiner)
        );
        return aggregate.toString().substring(0, aggregate.length() - 1);
    }

    public List<T> reverse() {
        List<T> listToReverse = (List<T>)_list;
        Collections.reverse(listToReverse);
        return listToReverse;
    }

    public List<T> sort(Comparator<T> sortComparer) {
        List<T> listToReverse = (List<T>)_list;
        Collections.sort(listToReverse, sortComparer);
        return listToReverse;
    }

    public int sum() {
        List<T> list = (List<T>)_list;
        int total = 0;
        for (T aList : list) {
            total += Integer.parseInt(aList.toString());
        }
        return total;
    }

    public List<T> minus(RockCollection<T> listToMinus) {
        List<T> list = (List<T>)_list;
        listToMinus.forEach(list::remove);
        return list;
    }

    public Double average() {
        List<T> list = (List<T>)_list;
        Double total = 0.0;
        for (T aList : list) {
            total += Double.parseDouble(aList.toString());
        }
        return total / list.size();
    }

    public T first() {
        return _list.stream().findFirst().get();
                //.collect(Collectors.<T>toList());
    }

    public T last() {
        List<T> list = (List<T>)_list;
        return list.get(_list.size() - 1);
    }

    //##############################################
    //Transform methods
    public List<T> toList() {
        return (List<T>)_list;
    }

    public Vector<T> toVector() {
        return (Vector<T>)_list;
    }

    public LinkedList<T> toLinkedList() {
        return (LinkedList<T>)_list;
    }

    public HashSet<T> toHashSet() {
        return (HashSet<T>)_list;
    }

    public TreeSet<T> toTreeSet() {
        return (TreeSet<T>)_list;
    }

    public Stack<T> toStack() {
        return (Stack<T>)_list;
    }

    //##############################################
    //Re-implement existing methods
    @Override
    public int size() {
        return _list.size();
    }

    @Override
    public boolean isEmpty() {
        return _list == null || _list.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        T item = find(searchItem -> searchItem.equals(o));
        return item != null;
    }

    @Override
    public Iterator<T> iterator() {
        return _list.iterator();
    }

    @Override
    public Object[] toArray() {
        return _list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        _list.add(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        _list.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return _list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        _list.addAll(c);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        _list.removeAll(c);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        _list.retainAll(c);
        return true;
    }

    @Override
    public void clear() {
        _list.clear();
    }
}
