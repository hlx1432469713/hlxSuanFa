package hash;

import java.util.*;

/**
 *date：2022-02-03
 *
 * message :  三数之和
 *
 * work : 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 */
public class hashNinetySix20220203 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            List<List<Integer>> result = threeSum2(nums);
            for(List<Integer> list : result){
                for(Integer i : list){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    //采用哈希法 需要进行去重（比较麻烦）
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 ||nums[0] > 0)
            return list;
        int index = Integer.MAX_VALUE;
        for(int i = 0;i <nums.length;i++){
            if (nums[i] == index)
                continue;
            else{
                index = nums[i];
            }
            int target = -nums[i];
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = i+1;j <nums.length;j++){
                List<Integer> numsList = new ArrayList<>();
                int flag = target - nums[j];
                if (map.containsKey(flag)){
                    numsList.add(-target);
                    numsList.add(nums[j]);
                    numsList.add(flag);
                    list.add(numsList);
                    map.remove(flag);
                }
                map.put(nums[j],j );
            }
        }
        return list;
    }
    //采用双指针法
    static public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //首先进行排序，使数组从小到大排序
        Arrays.sort(nums);
        for(int i =0;i < nums.length;i++){
            int start = i;
            int left = start + 1;
            int right = nums.length - 1;
            if (nums[start] > 0)
                break;
            //第一个数a  去重
            if (start > 0 && nums[start] == nums[start - 1])
                continue;
            while (left < right){
                if (nums[start] + nums[left] + nums[right] < 0)
                    left++;
                else if(nums[start] + nums[left] + nums[right] > 0)
                    right--;
                else {
                    list.add(Arrays.asList(nums[start], nums[left], nums[right]));
                    //第二个和第三个数字 b，c去重
                    while (right > left && nums[start] + nums[left] + nums[right] == 0)
                        left++;
                }
            }
        }
        return list;
    }

}
