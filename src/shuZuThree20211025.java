import java.util.Scanner;

/**
 *date：2021-10-25
 *
 * message ：二分查找（有序数组---无重复元素）
 *
 * work:给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]

 *
 *
 */

public class shuZuThree20211025 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0;i < n;i++)
            nums[i] = scanner.nextInt();
        int target = scanner.nextInt();
        int result[] = new int[2];
        result = searchRange(nums,target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
    //自己方法暴力求解
    static public int[] searchRange(int[] nums,int target){
        int first = -1,end = -1;
        for(int i = 0;i < nums.length;i++){
            if(target == nums[i]){
               if(first == -1){
                   first = i;
                   end = i;
               }
               end = i;
            }
        }
        return new int[]{first, end};
    }
}
