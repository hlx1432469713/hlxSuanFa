package shuZu;

import java.util.*;

/**
 *date：2022-04-06
 *
 * message : 503. 下一个更大元素 II
 *
 * work :给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），
 * 返回nums中每个元素的 下一个更大元素 。
 *
 * 数字 x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 *
 */
public class shuZuTwoHundredTwentyEight20220406 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int  n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++){
                nums[i] =scanner.nextInt();
            }
            int[] result = nextGreaterElements(nums);
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }
    static public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] list = new int[n];
        Arrays.fill(list,-1);
        if(n == 1)
            return list;
        Stack<Integer> stack = new Stack<>();
        int flag = 0;
        for(int i = 0;i < n;i = (i + 1) % n){
            if(!stack.isEmpty() ){
                if(i == stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty())
                    return list;
            }
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                list[stack.pop()] = nums[i];
            }
            if (flag < n) {
                stack.push(i);
                flag++;
            }
        }
        return list;
    }
}
