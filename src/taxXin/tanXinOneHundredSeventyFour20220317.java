package taxXin;

/**
 *date：2022-03-17
 *
 * message ：942. 增减字符串匹配
 *
 * work :由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果perm[i] < perm[i + 1]，那么s[i] == 'I'
 * 如果perm[i] > perm[i + 1]，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
。
 *
 *
 *

 */
public class tanXinOneHundredSeventyFour20220317 {
    public static void main(String[] args){

    }

    static  public int[] diStringMatch(String s) {
        int left = 0;//剩余数字的最小值
        int right = s.length() - 1;//剩余数字的最大值
        char[] list = s.toCharArray();
        int [] result = new int[s.length() + 1];
        for (int i = 0; i < list.length; i++) {
            //每次遇到‘I’，代表此时数字比较小，因此将最小值 放进去，同时更新剩余数字的最小值
            if (list[i] == 'I') {
                result[i] = left;
                left++;
            }
            //每次遇到‘D’，代表此时数字比较大，因此将最大值 放进去，同时更新剩余数字的最大值
            else if (list[i] == 'D'){
                result[i] = right;
                right--;
            }
        }
        //最后将剩余的最后一个数字放进数组的末尾
        result[s.length() + 1] = left;
        return result;
    }
}
