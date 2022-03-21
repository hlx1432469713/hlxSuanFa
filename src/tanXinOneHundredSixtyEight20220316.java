import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2022-03-14
 *
 * message ：561. 数组拆分 I
 *
 * work :给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从 1 到n 的 min(ai, bi) 总和最大。
 *
 * 返回该 最大总和 。
 *

 */
public class tanXinOneHundredSixtyEight20220316 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n;i++)
                nums[i] = scanner.nextInt();
            int result = arrayPairSum(nums);
            System.out.println(result);
        }
    }


    //排序
    static  public int arrayPairSum(int[] nums) {
        //首先对数组进行从小到大排序
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0;i < nums.length - 1;i = i + 2){
            sum += nums[i];
        }
        return sum;

    }
}
