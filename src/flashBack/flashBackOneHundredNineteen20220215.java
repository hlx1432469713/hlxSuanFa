package flashBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-15
 *
 * message : 二进制手表
 *
 * work : 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *        每个 LED 代表一个 0 或 1，最低位在右侧。
 */
public class flashBackOneHundredNineteen20220215 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            List<String> list = readBinaryWatch(n);
            for (String str : list)
                System.out.print(str + " ");
        }
    }
    static int[] times = {1,2,4,8,0,0,0,0,0,0};
    static int[] minus = {0,0,0,0,1,2,4,8,16,32};
    static List<String> list = new ArrayList<>();
    static  public List<String> readBinaryWatch(int turnedOn) {
        backtracking(turnedOn,0,0,0);
        return list;
    }

    static public void backtracking(int turnedOn,int time,int minutes,int start){
        if (time > 11 || minutes > 59)
            return;
        if (turnedOn == 0){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(time + ":");
            if (minutes < 10)
                stringBuilder.append(0);
            stringBuilder.append(minutes);
            list.add(String.valueOf(stringBuilder));
            return;
        }
        for (int i = start;i < times.length;i++)
                backtracking(turnedOn-1,time+times[i],minutes + minus[i],i+1);
    }

}
