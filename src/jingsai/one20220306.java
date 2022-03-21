package jingsai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-03-06
 *
 * message : 6019. 替换数组中的非互质数
 *
 * work : 给你一个整数数组 nums 。请你对数组执行下述操作：
 *
 * 从 nums 中找出 任意 两个 相邻 的 非互质 数。
 * 如果不存在这样的数，终止 这一过程。
 * 否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
 * 只要还能找出两个相邻的非互质数就继续 重复 这一过程。
 * 返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。
 *
 * 生成的测试用例可以保证最终数组中的值 小于或者等于 108 。
 *
 * 两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。
 */
public class one20220306 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0;i < n;i++)
                nums[i] = scanner.nextInt();
            List<Integer> list = replaceNonCoprimes(nums);
            for (Integer x : list)
                System.out.print(x + "  ");

        }

    }
    //主要问题就是  每次比较相邻后如果有新的数加进来，都需要前后重新对比（没有通过）
    static   public List<Integer> replaceNonCoprimes(int[] nums) {
        int left = 0;
        int right =left + 1;
        int index =0;
        List<Integer> list = new ArrayList<>();
        while(right < nums.length){
            int x1 = nums[left];
            int x2 = nums[right];
            int flag = gcd(x1 ,x2);
            if(flag > 1){
                left++;
                right++;
                long x = (long)x1 * x2 /  flag;
                nums[left] = (int)x;
            }else{
                while(index > 0 && gcd(x1,list.get(index - 1)) > 1){
                    x1 = (int)(long)x1 * list.get(index - 1) /  gcd(x1,list.get(index - 1)) ;
                    index--;
                }
                if(index == list.size()){
                    list.add(x1);
                    index++;
                }else {
                    list.set(index, x1);
                    index++;
                }
                left++;
                right++;
            }
        }

        return list;


    }

    static   public List<Integer> replaceNonCoprimes2(int[] nums) {
       List<Integer> list = new ArrayList<>();
       int index = 1;
       list.add(nums[0]);
        for (int i = 1;i < nums.length;i++){
            //是非互质数
            int x = nums[i];
            while(index > 0 && gcd(list.get(index - 1),x) > 1){
                x = (int)((long) x * list.get(index - 1) / gcd(list.get(index-1),x));//最小公倍数
                index--;
            }
            if (index == list.size()){
                list.add(x);
                index++;
            }else{
                list.set(index ,x);
                index++;
            }
        }


        return list.subList(0,index);


    }
    //辗转相除法
    static public int gcd(int x, int y){
        if(y == 0)
            return x;
        else
            return gcd(y,x%y);
    }
}
