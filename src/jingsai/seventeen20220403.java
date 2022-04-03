package jingsai;

/**
 *date：2022-04-03
 *
 * message ：6035. 选择建筑的方案数
 *
 * work : 给你一个下标从 0 开始的二进制字符串 s ，它表示一条街沿途的建筑类型，其中：
 *
 * s[i] = '0' 表示第 i 栋建筑是一栋办公楼，
 * s[i] = '1' 表示第 i 栋建筑是一间餐厅。
 * 作为市政厅的官员，你需要随机 选择 3 栋建筑。然而，为了确保多样性，选出来的 3 栋建筑 相邻 的两栋不能是同一类型。
 *
 * 比方说，给你s = "001101" ，我们不能选择第 1 ，3 和 5 栋建筑，
 * 因为得到的子序列是"011" ，有相邻两栋建筑是同一类型，所以 不合 题意。
 * 请你返回可以选择 3 栋建筑的 有效方案数 。
 *
 *
 */
public class seventeen20220403 {
    public static void main(String[] args) {}

    static  long sum = 0;
    int[] list = new int[2];
    public long numberOfWays(String s) {
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '0')
                list[0]++;
            else
                list[1]++;
        }
        int left = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '0')
                left++;
            else{
                sum += (long)(left * (list[0] - left));
            }
        }
        left = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '1')
                left++;
            else{
                sum += (long)(left * (list[1] - left));
            }
        }
        return sum;
    }
}
