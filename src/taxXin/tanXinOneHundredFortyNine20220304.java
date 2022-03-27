package taxXin;

import java.util.Scanner;

/**
 *date：2022-03-04
 *
 * message ：134. 加油站
 * work :在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 *time:  首次自己独立成功 650ms  32min
 *
 */
public class tanXinOneHundredFortyNine20220304 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int n = scanner.nextInt();
            int[] gas = new int[n];
            int[] cost = new int[n];
            for(int i = 0;i < n;i++)
                gas[i] = scanner.nextInt();
            for(int i = 0;i < n;i++)
                cost[i] = scanner.nextInt();
            int result = canCompleteCircuit(gas,cost);
            System.out.println(result);
        }
    }
    //自己想的暴力
    static  public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] flag = new int[gas.length];
        int sum = 0;
        for (int i = 0;i < gas.length;i++){
            flag[i] = gas[i] - cost[i];
            sum += flag[i];
        }
        if (sum < 0)
            return  - 1;
        for(int j = 0;j < flag.length;j++){
            if (flag[j] > 0){
                int k = j + 1;
                int num =flag[j];
                while(k != j){
                    if (k >=flag.length)
                        k = 0;
                    num += flag[k];
                    if (num < 0)
                        break;
                    k++;
                    if (k >=flag.length)
                        k = 0;
                }
                if (num >= 0)
                    return j;
            }
        }

        return 0;
    }
    static  public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int target = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            //计算区间剩余油量和，如果小于0，代表不能从这个区间开始出发，
            // 即出发地点start 变为 i+1（当前加油站的下一站），同时区间剩余油量和置为0，代表从下个加油站重新计算
            //一直根据这个原则，直到遍历结束，返回start
            target += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (target < 0) {
                start = i + 1;
                target = 0;
            }
        }
        //每站剩余油量 总合小于0，代表不能循环一周
        if (sum < 0)
            return -1;
        return start;
    }
}
