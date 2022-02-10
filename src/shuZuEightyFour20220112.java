import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2022-01-12
 *
 * message ：只出现一次的数字
 *
 * work:给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class shuZuEightyFour20220112 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i =0;i < n;i++)
                nums[i] = scanner.nextInt();
            int result = singleNumber(nums);
            System.out.println(result);

        }

    }
    //普通循环
    static public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 1;i = i+2){
            if(nums[i] != nums[i+1])
                return nums[i];
        }
        return nums[nums.length - 1] ;

    }
    //位运算
    static public int singleNumber2(int[] nums) {
        int num=0;
        for(int i=0;i<nums.length;i++){
            num=num^nums[i];
        }return num;

    }
}
