package com.bayuedekui.algorithmsketch.design;

import org.junit.Test;

import java.util.*;

public class lc1804_实现Trie前缀树II {
    Map<String, Integer> map;

    public lc1804_实现Trie前缀树II() {
        map = new HashMap<>();
    }

    public void insert(String word) {
        map.put(word, map.getOrDefault(word, 0) + 1);

    }

    public int countWordsEqualTo(String word) {
        int res = 0;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getKey().equals(word)) {
                res = entry.getValue();
            }
        }
        return res;

    }

    public int countWordsStartingWith(String prefix) {
        System.out.println(map);
        int res = 0;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getKey().startsWith(prefix)) {
                res += entry.getValue();
            }
        }
        return res;
    }

    public void erase(String word) {
        int cnt = map.get(word) - 1;
        if (cnt == 0) {
            map.remove(word);
        } else {
            map.put(word, cnt);
        }
    }

    @Test
    public void test(){
        System.out.println("cu".startsWith("cu"));
    }
}
