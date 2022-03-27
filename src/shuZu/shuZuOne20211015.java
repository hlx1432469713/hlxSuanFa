package shuZu;

import java.util.Scanner;

/**
 *date：2021-10-15
 *
 * message ：二分查找（有序数组--无重复元素）
 *
 * work:给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 *      写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 网站：https://segmentfault.com/a/1190000016825704（二分查找模板，用于后面整理上传）
 */

public class shuZuOne20211015 {
    public static void main(String[] args){
        //练习输入输出
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        //1.通过for循环暴力求解
        int result = -1;
//        for(int j = 0; j<n; j++){
//            if(nums[j] == target){
//                result = j;
//                break;
//            }
//        }
        //2.通过二分查找进行求解
        //2.1 第一种二分查找求解（[left,right]）左闭右闭
        int left = 0;
        int right = nums.length-1;
        if(target<nums[0] || target>nums[right]){
            result = -1;
        }
        while(left <= right){
            int mid  = left + ((right - left) >> 1);
            System.out.println("mid = "+mid);
            if(nums[mid] == target){
                result = mid;
                break;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        //2.1 第二种二分查找求解（[left,right））左闭右开
//        int left = 0;
//        int right = nums.length;//******区别
//        while(left<right){
//            int mid = left + ((right - left) >> 1);
//            System.out.println("mid = "+mid);
//            if(target == nums[mid]){
//                result = mid;
//                break;
//            }else if(target < nums[mid]){
//                right = mid ;//******区别
//            }else if(target > nums[mid]){
//                left = mid +1 ;
//            }
//        }
        System.out.println(result);

    }
}
