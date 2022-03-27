package taxXin;

import java.util.Scanner;

/**
 *date：2022-03-03
 *
 * message ：45. 跳跃游戏 II
 * work :给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 */
public class tanXinOneHundredFortyFive20220303 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] g = new int[n];
            for (int i = 0;i < n;i++){
              g[i] = scanner.nextInt();
            }
            int result = jump(g);

            System.out.println(result);
        }
    }
    static  public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int end =  0;//当前覆盖范围 <= maxLength
        int maxLength = 0;//能达到的最大范围
        int result = 0;//跳跃次数
        for(int i = 0;i < nums.length - 1;i++){
            //每次遍历更新最大范围
            maxLength = Math.max(maxLength,i + nums[i]);
            //当i 递增到当前覆盖范围终点  --跳跃次数+1
            if(i == end){
                result++;
                //当最大覆盖范围已经超过 数组下标，表示此次已经能够到达数组终点，直接返回跳跃次数
                if(maxLength >= nums.length - 1)
                    return result;
                //将maxLength 更新到 end中
                end = maxLength;
            }
        }
        return result;

    }
}
