import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-25
 *
 * message : 967. 连续差相同的数字
 *
 * work : 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
 *
 * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。
 * 例如，01 有一个前导零，所以是无效的；但 0是有效的。
 *
 * 你可以按 任何顺序 返回答案。
 *  示例 1：
 *
 * 输入：n = 3, k = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * 示例 2：
 *
 * 输入：n = 2, k = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * 示例 3：
 *
 * 输入：n = 2, k = 0
 * 输出：[11,22,33,44,55,66,77,88,99]
 * 示例 4：
 *
 * 输入：n = 2, k = 2
 * 输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 *
 */
public class flashBackOneHundredThirtySix20220225 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] result = numsSameConsecDiff(n,k);
            for (int i : result){
                System.out.print(i + "  ");
            }
        }
    }
    static List<Integer> list = new ArrayList<>();
    static StringBuilder stringBuilder = new StringBuilder();
    static  public int[] numsSameConsecDiff(int n, int k) {
        //backtracking(n,k);
        backtracking2(n,k,0);
        int[] num = new int[list.size()];
        for (int i = 0;i < list.size();i++)
            num[i] = list.get(i);
        return num;

    }
    static void backtracking(int n,int k){
        if (stringBuilder.length() == n){
            list.add(Integer.valueOf(stringBuilder.toString()));
            return;
        }
        for (int i = 0;i < 10;i++){
            if (stringBuilder.length() == 0 && i == 0)
                continue;
            if (stringBuilder.length() == 0)
                stringBuilder.append(i);
            else{
                int x = stringBuilder.charAt(stringBuilder.length() - 1) - '0';
                if (Math.abs(i - x) == k){
                    stringBuilder.append(i);
                }else
                    continue;
            }
            backtracking(n,k);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    //不使用stringBuilder
    static void backtracking2(int n,int k,int sum){
        if (sum >= Math.pow(10,n- 1)){
            list.add(sum);
            return;
        }
        for (int i = 0;i < 10;i++){
            if (sum == 0 && i == 0)
                continue;
            if (sum != 0){
                int x = sum % 10;
                if (Math.abs(x - i) != k)
                    continue;
            }
            backtracking2(n,k,10 * sum + i);
        }
    }
}
