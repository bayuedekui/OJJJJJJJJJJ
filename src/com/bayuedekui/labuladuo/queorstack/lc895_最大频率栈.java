package com.bayuedekui.labuladuo.queorstack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class lc895_最大频率栈 {
    /*HashMap<Integer, List<Integer>> freqToKeys;
    HashMap<Integer, Integer> keyToFreq;
    List<Integer> list;
    int maxFreq;

    public lc895_最大频率栈() {
        freqToKeys = new HashMap<>();
        keyToFreq = new HashMap<>();
        list = new ArrayList<>();
        maxFreq = 0;
    }

    public void push(int val) {
        list.add(val);
        int freq = keyToFreq.getOrDefault(val, 0);
        keyToFreq.put(val, freq + 1);
        List<Integer> vals = freqToKeys.get(freq);
        if (vals != null) {
            vals.remove(Integer.valueOf(val));
            if (vals.isEmpty()) {
                freqToKeys.remove(freq);
            } else {
                freqToKeys.put(freq, vals);
            }
        }
        freqToKeys.putIfAbsent(freq + 1, new ArrayList<>());
        freqToKeys.get(freq + 1).add(val);


        maxFreq = Math.max(maxFreq, keyToFreq.get(val));
        System.out.println("push(freqToKeys)==>" + freqToKeys);
        System.out.println("push(keyToFreq)==>" + keyToFreq);
        System.out.println("push(maxFreq)==>" + maxFreq);
    }

    public int pop() {
        System.out.println(list);
        int res = -1;
        List<Integer> vals = freqToKeys.get(maxFreq);
        // 这个导致了最后一个用例超时
        for (int i = list.size() - 1; i >= 0; i--) {
            res = list.get(i);
            if (vals.contains(list.get(i))) {
                list.remove(i);

                // (freq,cnt)也需要进行减少
                int freq = keyToFreq.get(res);
                List<Integer> oldVals = freqToKeys.get(freq);
                oldVals.remove(Integer.valueOf(res));
                if (oldVals.isEmpty()) {
                    freqToKeys.remove(freq);
                    maxFreq--;
                } else {
                    freqToKeys.put(freq, oldVals);
                }

                freqToKeys.putIfAbsent(freq - 1, new ArrayList<>());
                freqToKeys.get(freq - 1).add(res);

                // (val,freq)也需要进行减少
                keyToFreq.put(res, keyToFreq.get(res) - 1);
                break;
            }
        }
        return res;
    }*/


    HashMap<Integer, Integer> valToFreq;
    HashMap<Integer, Stack<Integer>> freqToStack;
    int maxFreq;

    public lc895_最大频率栈() {
        valToFreq = new HashMap<>();
        freqToStack = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);
        // 想freqToStack中更新，有则更新，无则新建
        freqToStack.putIfAbsent(freq, new Stack<>());
        freqToStack.get(freq).push(val);
    }

    public int pop() {
        Stack<Integer> tmpStack = freqToStack.get(maxFreq);
        int res = tmpStack.pop();
        valToFreq.put(res, valToFreq.get(res) - 1);

        if (tmpStack.isEmpty()) {
            maxFreq--;
        }
        return res;
    }

}
