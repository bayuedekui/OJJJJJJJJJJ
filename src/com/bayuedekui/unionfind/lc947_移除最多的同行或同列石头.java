package com.bayuedekui.unionfind;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class lc947_移除最多的同行或同列石头 {

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for (int[] stone : stones) {
            // 将x轴和y轴分开对待，都需要进行联通性分析
            uf.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - uf.getCount();

    }

    // 新建并查集对象
    class UnionFind {
        //记录某个节点的父节点（联络人）
        private Map<Integer, Integer> parent;
        // 连通分量，初始为零
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            count = 0;
        }

        public int getCount() {
            return count;
        }

        // 查询某个节点父节点，同时如果没有的话就直接赋值
        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }

            // 之只有parent.get(x)=x是x才是父节点
            if (x != parent.get(x)) {
                // 直接将存储x以及对应父节点
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        // 进行合并
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            // 当x的父节点和y的父节点一样时，啥不需要做
            if (rootX == rootY) {
                return;
            }
            // 当x与y的父节点不一样时，需要将x的父节点指向y的父节点
            parent.put(rootX, rootY);
            count--;
        }


    }


    @Test
    public void test() {
        int[][] stones = {{0, 1}, {1, 0}, {1, 1}};
        System.out.println(removeStones(stones));
    }


}
