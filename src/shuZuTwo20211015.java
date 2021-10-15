import java.util.Scanner;

/**
 *date：2021-10-15
 *
 * message ：二分查找
 *
 * work:给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *      请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
 */

public class shuZuTwo20211015 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int result = searchInsert(nums,target);
        System.out.println(result);
    }
     static public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int result  = 0;
        while(left <= right){
            int mid = left + ((right - left) >>1);
            result = mid;
            if(nums[mid] == target)
                return result;
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
                result = left;
            }
        }
        return result;
    }
}
