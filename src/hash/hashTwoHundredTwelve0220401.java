package hash;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *date：2022-04-01
 *
 * message : 954. 二倍数对数组
 *
 * work :给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <=i < len(arr) / 2，
 * 都有 arr[2 * i + 1] = 2 * arr[2 * i]”时，返回 true；否则，返回 false。
 *
 */
public class hashTwoHundredTwelve0220401 {
    public static void main(String args[]){}


    static public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i = 0;i < arr.length;i++){
            if(map.get(arr[i])!= 0){
                if(arr[i] >= 0){
                    if(!map.containsKey(arr[i] * 2) || map.get(arr[i] * 2) == 0){
                        return false;
                    }
                    map.put(arr[i]*2,map.get(arr[i]*2) - 1);
                }else{
                    if(arr[i] % 2 != 0){
                        return false;
                    }
                    if(!map.containsKey(arr[i] / 2) || map.get(arr[i] / 2) == 0){
                        return false;
                    }
                    map.put(arr[i]/2,map.get(arr[i]/2) - 1);
                }
                map.put(arr[i],map.get(arr[i]) - 1);
            }
        }
        return true;
    }
}
