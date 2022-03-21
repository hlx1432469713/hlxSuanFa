package jingsai;

import java.util.ArrayList;
import java.util.List;

/**
 *date：2022-03-13
 *
 * message : 5227. K 次操作后最大化顶端元素
 *
 * work : 给你一个下标从 0开始的整数数组nums，它表示一个 栈 ，其中 nums[0]是栈顶的元素。
 *
 * 每一次操作中，你可以执行以下操作 之一：
 *
 * 如果栈非空，那么 删除栈顶端的元素。
 * 如果存在 1 个或者多个被删除的元素，你可以从它们中选择任何一个，添加回栈顶，这个元素成为新的栈顶元素。
 * 同时给你一个整数k，它表示你总共需要执行操作的次数。
 *
 * 请你返回 恰好执行 k次操作以后，栈顶元素的 最大值。如果执行完 k次操作以后，栈一定为空，请你返回 -1。


 *
 */
public class seven20220313 {
    public static void main(String[] args) {

    }


    //第k次操作：  1.将已经移除的最大元素放回栈顶
    //              2.取出第k个元素，此时栈顶为第k + 1个元素
    static public int maximumTop(int[] nums, int k) {
        /**
         * 进行分类讨论：
         *  1.当nums.length == 1,k为奇数时，栈一定会为空 返回-1
         *  2.当 k > nums.length，可以取出所有元素，然后做一些无效操作，最后一次操作，将数组最大元素放回栈顶即可
         *  3.当 k == nums.length，可以取出k - 1个元素，然后将这k - 1个元素中最大的元素再第k次放回栈顶
         *  4.当 k < nums.length,可以取出k - 1个元素，然后将这k - 1个元素中最大值 和 第k + 1个元素进行比较，取较大值
    */
        int max = 0;
        if (nums.length == 1 && k % 2 == 1)
            return -1;
       for (int i = 0;i < (k > nums.length ? nums.length:k - 1);i++){
           max = Math.max(max,nums[i]);
       }
       if (k < nums.length)
           max = Math.max(max,nums[k]);
       return max;

    }
}
