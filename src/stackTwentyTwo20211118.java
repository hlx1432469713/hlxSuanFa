import java.util.Scanner;
import java.util.Stack;

/**
 *date：2021-11-18
 *
 * message ：逆波兰表达式求值
 *
 * work:有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */
public class stackTwentyTwo20211118 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       while(scanner.hasNext()) {
           int nums = scanner.nextInt();
           String[] tokens = new String[nums];
           for(int i = 0;i < nums;i++)
               tokens[i] = scanner.next();
           int result = evalRPN(tokens);
           System.out.println(result);
       }
    }

    static public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int x = 0,y = 0;
        for(int i = 0;i < tokens.length;i++){
            switch (tokens[i]){
                case "+" :
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(x + y));
                    break;
                case "-" :
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(y - x));
                    break;
                case "*" :
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(y * x));
                    break;
                case "/" :
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(y / x));
                    break;
                default:
                    stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());

    }


}
