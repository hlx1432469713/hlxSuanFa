package shuZu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *date：2022-04-22
 *
 * message :剑指 Offer 40. 最小的k个数
 *
 * work :输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 */
public class shuZuTwoHundredSeventyFive20220422 {
    public static void main(String[] args){}

    static  public int[] getLeastNumbers(int[] arr, int k) {
        int[] list = new int[k];
        if(k == 0)
            return list;
        Queue<Integer> queue = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o2.compareTo(o1);
            }
        });
        for(int i = 0;i < arr.length;i++){
            if(queue .size() != k){
                queue.offer(arr[i]);
            }else{
                if(queue.peek() > arr[i]){
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        int index = 0;
        for(int x : queue){
            list[index] = x;
            index++;
        }
        return list;
    }
}
