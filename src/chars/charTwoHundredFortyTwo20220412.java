package chars;

/**
 *date：2022-04-12
 *
 * message :806. 写字符串需要的行数
 *
 * work :我们要把给定的字符串 S从左到右写到每一行上，每一行的最大宽度为100个单位，
 * 如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。
 * 我们给定了一个数组widths，这个数组widths[0] 代表 'a' 需要的单位，
 * widths[1] 代表 'b' 需要的单位，...，widths[25] 代表 'z' 需要的单位。
 *
 * 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。

 */
public class charTwoHundredFortyTwo20220412 {
    public static void main(String[] args){}
    static  public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        result[0] = 1;
        for(int i = 0;i < s.length();i++){
            result[1] += widths[s.charAt(i) - 'a'];
            if(result[1] > 100){
                result[0]++;
                result[1] = widths[s.charAt(i) - 'a'];
            }
        }
        return result;
    }
}
