package flashBack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 *date：2022-02-21
 *
 * message :  找出不同的二进制字符串
 *
 * work : 给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。
 * 请你找出并返回一个长度为n且没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。
 */
public class flashBackOneHundredTwentyFive20220221 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] nums = new String[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.next();

            String result = findDifferentBinaryString2(nums);
            System.out.println(result);
        }

    }

    static public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (String s : nums){
            int x = Integer.parseInt(s,2);
            map.put(x,x);
        }
        for (int i = 0;i < Math.pow(2,n);i++){
            if (map.get(i) == null){
                String binStr = "";
                for(int j= n-1;j>=0;j--) {
                    binStr +=(i>>j)&1;
                }
                return binStr;
            }
        }
        return "";
    }
    static public String findDifferentBinaryString2(String[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>();
        for (String s: nums) set.add(s);
        backtracking(set, n);
        return stringBuilder.toString();
    }


    static StringBuilder stringBuilder = new StringBuilder();
   static public boolean backtracking(HashSet<String> hashSet,int n){
        if (stringBuilder.length() == n){
            if (!hashSet.contains(stringBuilder.toString())){
                return true;
            }
            return false;
        }
        for (int i = 0;i < 2;i++){
            stringBuilder.append(i);
            boolean flag = backtracking(hashSet,n);
            if (flag)
                return flag;
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return false;

   }


}
