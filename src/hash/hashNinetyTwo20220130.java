package hash;

import java.util.*;

/**
 *date：2022-01-30
 *
 * message :  两个数组的交集
 *
 * work : 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 */
public class hashNinetyTwo20220130 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n1 = scanner.nextInt();
            int[] nums1 = new int[n1];
            for (int i = 0;i < n1;i++)
                nums1[i] = scanner.nextInt();
            int n2 = scanner.nextInt();
            int[] nums2 = new int[n1];
            for (int i = 0;i < n1;i++)
                nums2[i] = scanner.nextInt();
            int[] result = intersection(nums1,nums2);
            for(int i : result){
                System.out.print(i + " ");
            }
        }
    }

    static public int[] intersection(int[] nums1, int[] nums2) {
       int index = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1){
            map.put(i,i);
        }
        for (int j : nums2){
            if (map.get(j) !=null){
                nums1[index] = j;
                index++;
                map.remove(j);
            }
        }
        int[] flag = new int[index];
        for (int i = 0;i < index;i++)
            flag[i] = nums1[i];
        return flag;
    }

    static public int[] intersection2(int[] nums1, int[] nums2) {
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums1){
           set.add(i);
        }
        for (int j : nums2){
            if (set.contains(j)){
                nums1[index] = j;
                index++;
                set.remove(j);
            }
        }
        int[] flag = new int[index];
        for (int i = 0;i < index;i++)
            flag[i] = nums1[i];
        return flag;
    }
}
