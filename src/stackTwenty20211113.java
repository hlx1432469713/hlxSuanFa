import java.util.Scanner;
import java.util.Stack;

/**
 *date：2021-11-13
 *
 * message ：括号匹配
 *
 * work:给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *          有效字符串需满足：
 *              左括号必须用相同类型的右括号闭合。
 *              左括号必须以正确的顺序闭合。
 */
public class stackTwenty20211113 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            boolean result = isValid(s);
            System.out.println(result);
        }

    }
    //自己写的入栈
    static public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            if(s.charAt(i) == ')'){
                if(stack.isEmpty())
                    return false;
                else if(stack.pop() != '('){
                    return false;
                }
            }else if(s.charAt(i) == '}'){
                if(stack.isEmpty())
                    return false;
                else if(stack.pop() != '{'){
                    return false;
                }
            }else if(s.charAt(i) == ']'){
                if(stack.isEmpty())
                    return false;
                else if(stack.pop() != '['){
                    return false;
                }
            }
        }
       return stack.isEmpty();
    }

    //更好的入栈
    static public boolean isValid2(String s) {
        Stack<Character> deque = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }
}
