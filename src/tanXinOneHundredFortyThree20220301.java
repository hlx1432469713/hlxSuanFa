
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-03-01
 *
 * message ：376. 摆动序列
 *
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如，[1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3)是正负交替出现的。
 *
 * 相反，[1, 4, 7, 2, 5]和[1, 7, 4, 5, 5] 不是摆动序列，
 * 第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 *
 */
public class tanXinOneHundredFortyThree20220301 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] g = new int[n];
            for (int i = 0;i < n;i++){
              g[i] = scanner.nextInt();
            }
            int result = wiggleMaxLength(g);
            System.out.println(result);
        }
    }
    static int length = 1;
    static LinkedList<Integer> list = new LinkedList<>();
    static  public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1)
            return 1;
        //backing(nums,0);
        return wiggleMaxLength2(nums);

    }

    ///超出时间限制
    static public void backing(int[] nums ,int start){
        if (length == nums.length)
            return;
        if (nums.length - start + list.size() < length)
            return;
        if (list.size() >= 3){
            int left = list.get(list.size() - 3);
            int mid = list.get(list.size() - 2);
            int right = list.get(list.size() - 1);
            if ((mid > left && mid > right) || (mid < left && mid < right)){
                length = Math.max(length,list.size());
            }else
                return;
        }else if(list.size() == 2 && length == 1){
            if (list.get(0) !=list.get(1)) {
                length =2;
            }
        }

        for (int i = start;i < nums.length;i++){
            list.add(nums[i]);
            backing(nums,i + 1);
            list.removeLast();
        }

    }

    //贪心算法  局部最优 -》 整体最优
    //使用贪心算法，找到当前的峰值让峰值尽可能的保持峰值，然后删除单一坡度上的节点。
    //使最前面类似于有一个头指针一样，里面存放的是原来的第一位数值，这样起点的坡度为0
    //则变相等于默认最右边有峰值，则res=1
    //满足峰值的条件是前面的小于0那么后面的差值大于0
    //或者前面的差值大于0那么后面的差值小于0
    //满足条件的就是峰值，res++
    //用两个变量记录当前的峰值cur和前面一对的峰值pre
    static  public int wiggleMaxLength2(int[] nums) {
        int result = 1;
        int pre = 0;
        int cur  = 0;
        for (int i = 0;i < nums.length - 1;i++){
            cur = nums[i + 1] - nums[i];
            if ((cur > 0 && pre <= 0) || (cur < 0 && pre >= 0)){
                result++;
                pre = cur;
            }

        }
        return result;

    }
}
