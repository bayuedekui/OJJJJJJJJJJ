package com.bayuedekui.labuladuo.queorstack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lc341_扁平化嵌套列表迭代器 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    Iterator<Integer> iter;


    public lc341_扁平化嵌套列表迭代器(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        traceback(list,nestedList);
        iter = list.iterator();
    }

    /*@Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }*/

    public void traceback(List<Integer> list, List<NestedInteger> nestedList) {
        for (NestedInteger ne : nestedList) {
            if(ne.isInteger()){
                list.add(ne.getInteger());
            }else{
                traceback(list, ne.getList());
            }
        }
    }
}
