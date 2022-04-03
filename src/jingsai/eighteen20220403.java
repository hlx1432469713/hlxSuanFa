package jingsai;

/**
 *date：2022-04-03
 *
 * message ：6055. 转化时间需要的最少操作数
 *
 * work : 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 *
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。
 * 最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 *
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 *
 * 返回将current 转化为 correct 需要的 最少操作数 。
 *
 */
public class eighteen20220403 {
    public static void main(String[] args) {}

    static  public int convertTime(String current, String correct) {
        int sum = 0;
        String[] c1 = current.split(":");
        String[] c2 = correct.split(":");
        int x1 = Integer.valueOf(c1[0]);
        int y1 = Integer.valueOf(c1[1]);
        int x2 = Integer.valueOf(c2[0]);
        int y2 = Integer.valueOf(c2[1]);
        int flag = x2 * 60 + y2 - (x1 * 60 + y1);
        sum += flag / 60;
        flag = flag % 60;
        sum += flag / 15;
        flag = flag % 15;
        sum += flag / 5;
        flag = flag % 5;
        sum += flag;
        return sum;
    }
}
