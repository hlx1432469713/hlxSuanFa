import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *date：2021-11-19
 *
 * message ：左旋转字符串
 *
 * work:字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 */
public class charTwentySix20211119 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            int k = scanner.nextInt();
            String result = reverseLeftWords(s,k);
            System.out.println(result);
        }
    }

    //用队列--用时过长
    static public String reverseLeftWords(String s, int n) {
        Queue<Character> queue = new LinkedList<>();
        String result = "";
        for(int i = 0;i < s.length();i++){
            if(i < n){
                queue.offer(s.charAt(i));
            }else{
                result += s.charAt(i);
            }
        }
        while(!queue.isEmpty()){
            result += queue.poll();
        }
        return result;
    }

    //先局部反转  再  整体反转
    static private  String reverseLeftWords2(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        return sb.reverse().toString();
    }
    private static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
