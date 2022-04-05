package shuZu;


/**
 *date：2022-04-04
 *
 * message :307. 给你一个数组 nums ，请你完成两类查询。
 *
 * 其中一类查询要求 更新 数组nums下标对应的值
 * 另一类查询要求返回数组nums中索引left和索引right之间（包含）
 * 的nums元素的 和，其中left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组nums中索引left和索引right之间
 * （包含）的nums元素的 和（即，nums[left] + nums[left + 1], ..., nums[right]）
 */
public class shuZuTwoHundredSixteen20220404 {
    public static void main(String args[]){}
    int[] tree;
    int n ;
    int lowbit(int x){
        return x & -x;
    }
    //查询前缀和的方法
    int query(int x){
        int ans = 0;
        for(int i = x;i > 0;i -= lowbit(i))
            ans += tree[i];
        return ans;
    }
    //在树状数组x位置增加值u
    void add(int x,int u){
        for(int i = x;i <= n ;i+= lowbit(i)){
            tree[i] += u;
        }
    }
    private int[] sum;
    private int[] nums;
//    public NumArray(int[] nums) {
//        this.nums = nums;
//        n = nums.length;
//        tree = new int[n + 1];
//        for (int i = 0;i < n;i++)
//            add(i +1,nums[i]);
//    }

    public void update(int index, int val) {
        add(index + 1,val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

}
