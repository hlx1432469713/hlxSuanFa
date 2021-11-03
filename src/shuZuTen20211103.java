import java.util.Scanner;

/**
 *date：2021-11-03
 *
 * message ：双指针法（移除元素）
 *
 * work:给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
 *      如果相等，返回 true ；否则，返回 false 。注意：如果对空文本输入退格字符，文本继续为空。
 *
 */
public class shuZuTen20211103 {
    public static void main(String[] args){
     Scanner scanner = new Scanner(System.in);
     String str1 = scanner.next();
     String str2 = scanner.next();
     boolean result = backspaceCompare(str1,str2);
     System.out.println(result);
    }

    //用双指针法
    static public boolean backspaceCompare(String s, String t) {
        int skipS = 0,skipT = 0;
        int i = s.length()-1,j = t.length()-1;
        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(s.charAt(i) == '#') {
                    skipS++;
                    i--;
                }
                else if(s.charAt(i) != '#' && skipS!=0) {
                    skipS--;
                    i--;
                }else
                    break;
            }
            while(j >= 0){
                if(t.charAt(j) == '#') {
                    skipT++;
                    j--;
                }
                else if(t.charAt(j) != '#' && skipT!=0) {
                    skipT--;
                    j--;
                }else
                    break;
            }
            if(i >= 0 && j >= 0){
                if(s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }else{
                if(i >= 0 || j >=0){
                    return false;
                }
            }
            i--; j--;
        }
        return true;
    }
}
