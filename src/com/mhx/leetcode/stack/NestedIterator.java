package com.mhx.leetcode.stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private int index = -1;
    private List<NestedInteger> nestedList;
    private List<Integer> resultList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.resultList = getResultList(nestedList);
    }

    public List<Integer> getResultList(List<NestedInteger> nestedIntegers) {
        List<Integer> resultList = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedIntegers) {
            resultList.addAll(getResultList(nestedInteger));
        }
        return resultList;
    }

    public List<Integer> getResultList(NestedInteger nestedInteger) {
        List<Integer> resultList = new LinkedList<>();
        if (nestedInteger.isInteger()) {
            resultList.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger nestedInteger1 : nestedInteger.getList()) {
                resultList.addAll(getResultList(nestedInteger1));
            }
        }
        return resultList;
    }

    @Override
    public Integer next() {
        return resultList.get(++index);
    }

    @Override
    public boolean hasNext() {
        return index + 1 < resultList.size();
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */