package taxXin;

import java.util.Scanner;

/**
 *date：2022-03-14
 *
 * message ：11. 盛最多水的容器
 *
 * work :给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *
 */
public class tanXinOneHundredSeventyOne20220316 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int[] height = new int[n];
            for (int i = 0;i < n;i++)
                height[i] = scanner.nextInt();
            int maxArea = maxArea(height);
            System.out.println(maxArea);
        }
    }



    static public int maxArea(int[] height) {
        int max = 0;
       int left = 0;
       int right = height.length - 1;
       while(left < right){
           max = Math.max(max,(right - left) * (height[left] < height[right] ? height[left] : height[right]));
           int min = Math.min(height[left],height[right]);
          while(left < right && height[left] <= min)
              left++;
          while(left < right && height[right] <= min)
              right--;
       }
       return max;

    }
}
