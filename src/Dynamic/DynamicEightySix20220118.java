package Dynamic;

import java.util.Scanner;

/**
 *date：2022-01-18
 *
 * message :  跳跃游戏
 *
 * work : 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class DynamicEightySix20220118 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       while(scanner.hasNext()){
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0;i < n;i++)
               nums[i] = scanner.nextInt();
           boolean flag = canJump(nums);
           System.out.println(flag);
       }
    }

    static public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        int max = 0;//最大覆盖范围
        for(int i = 0;i < nums.length - 1;i++){
            max = Math.max(max, i + nums[i]);
            //当前最大覆盖范围只到 当前元素本身，意味着不能继续走下去，返回false
            if(max <= i)
                return false;
            //当前最大覆盖范围  已经到最后一个元素，意味着能够到达最后一个下标  直接返回true；
            if(max >= nums.length - 1)
                return true;
        }
        return false;
    }
    static public boolean canJump2(int[] nums) {
        if(nums.length == 1)
            return true;
        int max = 0;//最大覆盖范围
        //在最大覆盖范围内移动
        for(int i = 0;i <= max;i++){
            max = Math.max(max, i + nums[i]);
            //当前最大覆盖范围  已经到最后一个元素，意味着能够到达最后一个下标  直接返回true；
            if(max >= nums.length - 1)
                return true;
        }
        return false;
    }

    //动态规划
    static public boolean canJump3(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return true;
        int pre = n - 1;
        int cur = n - 2;
        while(cur >= 0){
            //代表可以从cur的位置跳到pre的位置
            if(nums[cur] >= pre - cur){
                pre = cur;
            }
            cur--;
        }
        //最后如果pre == 0，代表可以由最开始0位置开始进行跳跃，最后可以跳到最后一个位置
        if(pre == 0)
            return true;
        return false;
    }

}
