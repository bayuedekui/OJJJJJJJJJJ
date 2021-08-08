package com.bayuedekui.algorithmsketch.design;

import java.net.Inet4Address;
import java.util.*;

public class lc1500_设计文件分享系统 {
    // 用来保存m,记录文件快是否超过
    int m;

    // 记录当前新增到多少userId
    int userId;

    // 小顶堆，每次将最小的取出,记录被释放的userId,然后进行排序
    PriorityQueue<Integer> priQue;

    Map<Integer, List<Integer>> map;

    public lc1500_设计文件分享系统(int m) {
        this.m = m;
        userId = 1;
        priQue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        map = new HashMap<>();
    }

    public int join(List<Integer> ownedChunks) {
        int res = 0;
        if (!priQue.isEmpty()) {
            int newId = priQue.poll();
            map.put(newId, new ArrayList<>(ownedChunks));
            res = newId;
        } else {
            map.put(userId, new ArrayList<>(ownedChunks));
            res = userId;
            userId++;
        }
        System.out.println("join===" + priQue);
        return res;
    }

    public void leave(int userID) {
        map.remove(userID);
        priQue.offer(userID);
        System.out.println("leave===" + priQue);
    }

    public List<Integer> request(int userID, int chunkID) {
        List<Integer> res = new ArrayList<>();
        // 先查出来有没有，自己的不能算
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().contains(chunkID)) {
                res.add(entry.getKey());
            }
        }
        // 如果有将userID的map中增加进来
        if (!res.isEmpty()) {
            List<Integer> tmp = map.get(userID);
            if (tmp != null) {
                tmp.add(chunkID);   //这块将chunkID写成了userID
                map.put(userID, tmp);
            } else {
                map.put(userID, new ArrayList<>(chunkID));
            }
        }
        return res;
    }
}
