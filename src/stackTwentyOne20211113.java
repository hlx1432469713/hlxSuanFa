import java.util.Scanner;
import java.util.Stack;

/**
 *date：2021-11-13
 *
 * message ：删除字符串中的所有相邻重复项
 *
 * work:给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *      在 S 上反复执行重复项删除操作，直到无法继续删除。在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class stackTwentyOne20211113 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            String result = removeDuplicates(s);
            System.out.println(result);
        }

    }

    //创建一个栈
    static public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> stackOut = new Stack<Character>();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch )
                stack.push(ch);
            else {
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            stackOut.push(stack.pop());
        }
        while(!stackOut.isEmpty()){
            stringBuffer.append(stackOut.pop());
        }
        return String.valueOf(stringBuffer);

    }

    //直接将一个字符串当作栈
    static public String removeDuplicates2(String s) {
        // 将 res 当做栈
        StringBuffer res = new StringBuffer();
        // top为 res 的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }

    //一个比较优化的方法
    static  public String removeDuplicates3(String s) {
        char[] chars = s.toCharArray();
        int top = -1;

        for (int i = 0; i < chars.length; i++) {
            if(top >= 0 && chars[top] == chars[i]){
                top--;
            }else {
                chars[++top] = chars[i];
            }
        }
        return String.valueOf(chars,0,top+1);
    }

}
