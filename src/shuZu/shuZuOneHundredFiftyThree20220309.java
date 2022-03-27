package shuZu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-03-09
 *
 * message :  798. 得分最高的最小轮调
 *
 * work : 给你一个数组nums，我们可以将它按一个非负整数 k 进行轮调，
 * 这样可以使数组变为[nums[k], nums[k + 1], ... nums[nums.length - 1], nums[0], nums[1], ..., nums[k-1]]的形式。
 * 此后，任何值小于或等于其索引的项都可以记作一分。
 *
 * 例如，数组为nums = [2,4,1,3,0]，我们按k = 2进行轮调后，它将变成[1,3,0,2,4]。
 * 这将记为 3 分，因为 1 > 0 [不计分]、3 > 1 [不计分]、0 <= 2 [计 1 分]、2 <= 3 [计 1 分]，4 <= 4 [计 1 分]。
 * 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调下标 k 。如果有多个答案，返回满足条件的最小的下标 k 。
 *
 *
 *
 */
public class shuZuOneHundredFiftyThree20220309 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0;j < n;j++)
                nums[j] = scanner.nextInt();
           int result = bestRotation(nums);
           System.out.print(result + " ");
        }
    }

    //时间复杂度过高
    static public int bestRotation(int[] nums) {
        int max = 0;
        int index = 0;
        for (int i = 0;i < nums.length;i++){
            int sum = 0;
            List<Integer> list = getList(nums,i);
            for (int j = 0;j < list.size();j++){
                if (list.get(j)<=j){
                    sum++;
                }
            }
            if (sum > max){
                max = sum;
                index = i;
            }
        }
        return index;

    }
    static private List<Integer> getList(int[] nums,int k){
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if (right >= k){
                if (list.size() == 0) {
                    list.add(nums[right]);
                    right--;
                }
                else {
                    list.add(0, nums[right]);
                    right--;
                }
            }else{
                list.add(nums[left]);
                left++;
            }
        }
        return list;
    }

    static public int bestRotation2(int[] nums){
        int n = nums.length;
        int[] diffs = new int[n];
        for (int i = 0;i < n;i++){
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;
            diffs[low]++;
            diffs[high]--;
            if (low >= high){
                diffs[0]++;
            }
        }
        int bestId = 0;
        int maxScore = 0;
        int score = 0;
        for (int i = 0; i < n;i++){
            score += diffs[i];
            if (score > maxScore){
                bestId = i;
                maxScore = score;
            }
        }
        return bestId;
    }
}
