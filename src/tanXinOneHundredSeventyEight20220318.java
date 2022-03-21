import java.util.Scanner;

/**
 *date：2022-03-18
 *
 * message ：1221. 分割平衡字符串
 *
 * work :在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
 *
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 *
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 */
public class tanXinOneHundredSeventyEight20220318 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.next();
            int i = balancedStringSplit(s);
            System.out.println(i);
        }

    }

    static public int balancedStringSplit(String s) {
        char[] list = s.toCharArray();
        int RNum = 0;
        int LNum = 0;
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            switch (list[i]) {
                case 'R':
                    RNum++;
                    break;
                case 'L':
                    LNum++;
                default:
                    break;
            }
            if (RNum == LNum) {
                sum++;
                LNum = 0;
                RNum = 0;
            }
        }
        return sum;
    }
}
