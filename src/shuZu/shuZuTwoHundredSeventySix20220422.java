package shuZu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *date：2022-04-22
 *
 * message :剑指 Offer 11. 旋转数组的最小数字
 *
 * work :把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 *
 */
public class shuZuTwoHundredSeventySix20220422 {
    public static void main(String[] args){}

    //使用二分查找
    static  public int minArray(int[] numbers) {
        int left = 0,right = numbers.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }else if(numbers[mid] == numbers[right]){
                right--;
            }else{
                right = mid;
            }
        }
        return numbers[left];

    }
}
