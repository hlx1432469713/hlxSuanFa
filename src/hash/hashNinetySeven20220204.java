package hash;

import java.util.*;

/**
 *date：2022-02-04
 *
 * message :  四数之和
 *
 * work : 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：

 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class hashNinetySeven20220204 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0 ;i < n;i++)
                nums[i] = scanner.nextInt();
            int target = scanner.nextInt();
            List<List<Integer>> result = fourSum(nums,target);
            for(List<Integer> list : result){
                for(Integer i : list){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }

    }
    // -2 -1 0 0 1 2
    static public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i++){
            int start1 = i;
            if (i > 0 && nums[start1] == nums[start1 - 1])
                continue;
            int index = target - nums[start1];
            for (int j = i+1;j < nums.length;j++){
                int start2 = j;
                if (j > i+1 && nums[start2] == nums[start2 - 1])
                    continue;
                int left = start2 + 1;
                int right = nums.length - 1;
                while (left < right){
                    if (nums[start2] + nums[left] + nums[right] < index)
                        left++;
                    else if (nums[start2] + nums[left] + nums[right] > index)
                        right--;
                    else {
                        list.add(Arrays.asList(nums[start1],nums[start2] , nums[left] , nums[right]));
                        while (left < right && nums[start2] + nums[left] + nums[right] == index )
                            left++;
                    }
                }
            }
        }
        return list;
    }

}
