package shuZu;
import java.util.TreeSet;

/**
 *date：2022-03-30
 *
 * message :  220. 存在重复元素 III
 *
 * work :给你一个整数数组 nums 和两个整数k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 */
public class shuZuTwoHundredFour20220330 {
    public static void main(String args[]){}

    /**
     * treeSet.ceiling(x):返回大于等于 x 的最小元素
     *
     * 第一个问题：采用TreeSet数据结构
     * 第二个问题：采用滑动窗口
     * 第三个问题：数据大小越界问题
     * 第四个问题：如何比较
     * @param nums
     * @param k
     * @param t
     * @return
     */
    static  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 1 || k == 0)
            return false;
        int left = 0;
        int right = 1;
        TreeSet<Long> treeSet = new TreeSet();
        long[] myNum = new long[nums.length];
        for(int i = 0;i<nums.length;i++){
            myNum[i] = nums[i];
        }
        treeSet.add(Long.valueOf(myNum[0]));
        while(left < right && right < nums.length){
            while(right - left > k){
                treeSet.remove(myNum[left]);
                left++;
            }
            long flag = myNum[right] - t;
            long index = myNum[right] + t;
            if (treeSet.ceiling(flag)!=null && treeSet.ceiling(flag) <= index){
                return true;
            }
            treeSet.add( myNum[right]);
            right++;
        }
        return false;
    }

    //treeSet.ceiling(x):返回大于等于 x 的最小元素
    //注意int 的最大值 要转换为long
    static public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(nums.length == 1 || k == 0)
            return false;
        TreeSet<Long> treeSet = new TreeSet();
        for(int i = 0;i < nums.length;i++){
            long flag = nums[i] * 1L;
            if (treeSet.ceiling(flag -t ) !=null && treeSet.ceiling(flag -t) <= flag + t )
                return true;
            treeSet.add(flag);
            //滑动窗口
            if(i >= k){
                treeSet.remove(nums[i - k]*1L);
            }
        }
        return false;
    }
}
