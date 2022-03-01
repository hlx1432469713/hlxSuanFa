import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-23
 *
 * message :  统计按位或能得到最大值的子集数目
 *
 * work :给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 *
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。
 * 如果选中的元素下标位置不一样，则认为两个子集 不同 。
 *
 * 对数组 a 执行 按位或，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 */
public class flashBackOneHundredThirtyTwo20220224 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] num = new int[n];
            for (int i = 0;i < n;i++)
                num[i] = scanner.nextInt();
            int flag  = countMaxOrSubsets(num);
            System.out.println(flag);
        }
    }
    static int sum = 0;
    static public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for(int p : nums){
            max |= p;
        }
        backtracking(nums,0,0,max);
        return sum;
    }
    static public void backtracking(int[] nums,int start,int all,int max){
        if(all == max){
            sum += 1 << (nums.length - start);
            return;
        }
        for (int i = start;i < nums.length;i++){
            backtracking(nums,i + 1,all | nums[i],max);
        }

    }


}
