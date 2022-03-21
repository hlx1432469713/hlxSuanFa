import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 *date：2022-03-17
 *
 * message ：605. 种花问题
 *
 * work :假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数n ，能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
 *
 *
 *

 */
public class tanXinOneHundredSeventyThree20220317 {
    public static void main(String[] args){

    }

    static public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0)
            return true;
        if (flowerbed.length == 1){
            if (flowerbed[0] == 0)
                return true;
            else
                return false;
        }
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 1) {
                i++;
            }else if(flowerbed[i] == 0 && flowerbed[i + 1] == 1){
                i += 2;
            }else{
                n--;
                i++;
            }
            if (i == flowerbed.length - 2){
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0)
                    n--;
            }
            if (n <= 0)
                return true;
        }
        return false;
    }

    //进行上一个方法 代码精简
    static public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if(n == 0)
            return true;
        for (int i = 0; i < flowerbed.length && n > 0;) {
            if (flowerbed[i] == 1) {
                i += 2;
            }else if(i == flowerbed.length - 1 || flowerbed[i + 1] == 0){
               n--;
               i += 2;
            }else{
               i += 3;
            }
        }
        return n <= 0;
    }
}
