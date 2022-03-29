package chars;

import java.util.Scanner;

/**
 *date：2022-03-29
 *
 * message :2024. 考试的最大困扰度
 *
 * work : 一位老师正在出一场由 n 道判断题构成的考试，
 * 每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。
 * 老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。
 * （也就是连续出现 true 或者连续出现 false）。
 *
 * 给你一个字符串answerKey，其中 answerKey[i] 是第 i 个问题的正确结果。
 * 除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 *
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i]
 * 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 *
 *
 */
public class charOneHundredNintyNine20220329 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s =scanner.next();
            int k = scanner.nextInt();
            int result = maxConsecutiveAnswers(s,k);
            System.out.println(result);
        }
    }

    /**
     * 滑动窗口
     * @param
     * @return
     */
    static  public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getNum(answerKey,'T',k),getNum(answerKey,'F',k));
    }

    static public int getNum(String s,char c,int k){
        int sum = 0;
        int left = 0;
        int right = 0;
        int max = 0;
        while(left <= right && right < s.length()){
            if (s.charAt(right) != c){
                sum++;
            }
            while(sum > k){
                if(s.charAt(left) != c){
                    sum--;
                }
                left++;
            }
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}
