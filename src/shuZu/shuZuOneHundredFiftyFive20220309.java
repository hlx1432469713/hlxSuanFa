package shuZu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-03-09
 *
 * message :  1109. 航班预订统计（21：39 - 21:47）
 *
 * work : 这里有n个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在
 * 从 firsti到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
 *
 * 请你返回一个长度为 n 的数组answer，里面的元素是每个航班预定的座位总数。
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 */
public class shuZuOneHundredFiftyFive20220309 {
    public static void main(String args[]){
    }

    static public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            result[booking[0] - 1] += booking[2];
            if (booking[1] < n)
                result[booking[1]] -= booking[2];
        }
        for (int i = 1; i < n;i++){
            result[i] = result[i - 1] + result[i];
        }
        return result;
    }
}
