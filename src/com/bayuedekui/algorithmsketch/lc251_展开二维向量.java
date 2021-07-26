package com.bayuedekui.algorithmsketch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * <p>
 * iterator.next(); // 返回 1
 * iterator.next(); // 返回 2
 * iterator.next(); // 返回 3
 * iterator.hasNext(); // 返回 true
 * iterator.hasNext(); // 返回 true
 * iterator.next(); // 返回 4
 * iterator.hasNext(); // 返回 false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-2d-vector
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lc251_展开二维向量 {
    LinkedList<Integer> list = new LinkedList<>();

    public lc251_展开二维向量(int[][] vec) {

        for (int i = 0; i < vec.length; i++) {
            int[] tmp = vec[i];
            for (int j = 0; j < tmp.length; j++) {
                list.offerLast(tmp[j]);
            }
        }
    }

    public int next() {
        return list.pollFirst();

    }

    public boolean hasNext() {
        return list.isEmpty();
    }
}
