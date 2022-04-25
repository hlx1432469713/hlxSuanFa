package shuZu;

import TreeNode.TreeNode;

import java.util.Arrays;

/**
 *date：2022-04-23
 *
 * message :剑指 Offer 61. 扑克牌中的顺子
 *
 * work :从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，
 * 即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
 *
 */
public class shuZuTwoHundredEightyTwo20220423 {
    public static void main(String[] args){}
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] == 0){
                zero++;
                continue;
            }
            if(nums[i + 1] - nums[i] > 1)
                zero -= nums[i + 1] - nums[i] - 1;
            if(zero < 0 || nums[i + 1] == nums[i])
                return false;
        }
        return true;

    }
}
