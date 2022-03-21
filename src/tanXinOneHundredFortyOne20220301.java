import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2022-03-01
 *
 * message ：455. 分发饼干
 *假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，
 * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 */
public class tanXinOneHundredFortyOne20220301 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] g = new int[n];
            for (int i = 0;i < n;i++){
              g[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();
            int[] s = new int[m];
            for (int i = 0;i < m;i++){
                s[i] = scanner.nextInt();
            }
            int result = findContentChildren(g,s);

            System.out.println(result);
        }
    }
    static   public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int end = 0;
        while(start<g.length && end<s.length){
            if (g[start] <= s[end]){
                start++;
                end++;
            }else{
                end++;
            }
        }
        return start;

    }
}
