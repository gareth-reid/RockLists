package com.gareth;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Author: Gareth Reid

public class RockCollection<T extends Comparable<T>> implements Collection<T> {
    private Collection<T> _list = new ArrayList<T>();

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
        int total = 0;
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

    public List<T> toList() {
        return (List<T>)_list;
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
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        _list = new LinkedList<T>();
    }
}
