package chars;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *date：2021-11-19
 *
 * message ：替换空格
 *
 * work:给请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 *


 */
public class charTwentyFive20211119 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String result = replaceSpace(s);
            System.out.println(result);
        }
    }

    static public String replaceSpace(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0;i < s.length();i++){
            switch (s.charAt(i)){
                case ' ':
                    queue.offer('%');
                    queue.offer('2');
                    queue.offer('0');
                    break;
                default:
                    queue.offer(s.charAt(i));
                    break;
            }
        }
        String result = "" ;
        while(!queue.isEmpty()){
            result = result +queue.poll();
        }
        return result;
    }
}
