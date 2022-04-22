package Dynamic;

/**
 *date：2022-04-22
 *
 * message :396. 旋转函数
 *
 * work :给定一个长度为 n 的整数数组nums。
 *
 * 假设arrk是数组nums顺时针旋转 k 个位置后的数组，我们定义nums的 旋转函数F为：
 *
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回F(0), F(1), ..., F(n-1)中的最大值
 *
 * 生成的测试用例让答案符合32 位 整数。
 *
 *
 */
public class DynamicTwoHundredSeventySeven20220422 {
    public static void main(String[] args){}

    //暴力查找----超出时间限制
    static   public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;
        long max = 0;
        for(int i = 0;i < n;i++)
            max += (long)(i * nums[i]);
        int flag = 1;
        while(flag <=n){
            long index = 0;
            int start = n - flag;
            for(int i = 0;i < n;i++){
                index += (long)(i * nums[start % n]);
                start++;
            }
            if(index > max)
                max = index;
            flag++;
        }
        return (int)max;
    }

    static  public int maxRotateFunction2(int[] nums) {
        //F(x) = F(x - 1) + sum - n*nums[i]
        int n = nums.length;
        if (n == 1)
            return 0;
        int max = 0;
        int sum = 0;//数组的总和
        for(int i = 0;i < n;i++) {
            max += i * nums[i];
            sum += nums[i];
        }
        int flag = max;//当作F（0）的值
        for(int i = n - 1;i>=1;i--){
            int all = flag + sum - n * nums[i];
            max = Math.max(max,all);
            flag = all;
        }
        return max;

    }
}
