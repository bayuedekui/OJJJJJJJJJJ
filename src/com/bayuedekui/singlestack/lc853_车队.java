package com.bayuedekui.singlestack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class lc853_车队 {
    public int carFleet(int target, int[] position, int[] speed) {
        // 将车按照初始位置的升序排序（即离终点越近的位置排在越后面）
        // 同时计算每个汽车到终点所需要的时间
        // 从最接近终点的车位置开始倒序遍历，如果前一辆（离终点远）所需时间大于后一辆，那么永远追不上，车队+1
        // 如果前一辆（离终点远）所需时间小于后一辆，那么能追上，车队数不变，同时取后一辆（慢的车）代替，因为慢车会阻止快车前进
        int len = position.length;
        // car[0]表示初始位置，car[1]表示到终点所需时间
        double[][] car = new double[len][2];
        for (int i = 0; i < len; i++) {
            car[i][0] = position[i];
            car[i][1] = ((double) target - (double) position[i]) / ((double) speed[i]);
        }
        // 按照初始位置进行升序排序
        Arrays.sort(car, (o1, o2) -> (int) (o1[0] - o2[0]));

        // 计算车队数量,最少是一个车队
        int carQueCnt = 1;
        for (int i = len - 1; i >= 1; i--) {
            if (car[i][1] < car[i - 1][1]) {
                // 离终点近的车速度比离终点远的车的速度快，那慢车永远追不上快车，车队数量+1
                carQueCnt++;
            } else {
                // 离终点远的车速度快到能赶上离终点近的车，则被车速慢的车阻塞，形成一个车队
                car[i - 1] = car[i];
            }
        }
        return carQueCnt;
    }

    @Test
    public void test(){
        int target = 10;
        int[] position = new int[]{0, 4, 2};
        int[] speed = new int[]{2, 1, 3};
        System.out.println(carFleet(target, position, speed));

    }
}
