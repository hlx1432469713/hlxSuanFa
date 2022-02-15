import java.util.*;

/**
 *date：2022-02-11
 *
 * message :  分割回文串
 *
 * work : 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class flashBackOneHundredEight20220211 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            List<List<String>> str = partition(s);
            for (List<String> i : str){
                System.out.print("[ ");
                for (String j : i)
                    System.out.print(j + " ,");
                System.out.print(" ] ");
            }
        }
    }
    static LinkedList<String> path = new LinkedList<>();
    static List<List<String>> list = new ArrayList<>();
    static public List<List<String>> partition(String s) {
        backtracking(s,0);
        return list;
    }
    static public void backtracking(String s,int start) {
        if (start >= s.length()){
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = start;i <s.length();i++){
           if (isPalindrome(s,start,i)){
               path.add(s.substring(start,i+1));
               backtracking(s,i + 1);
               path.removeLast();
           }
        }
    }
//判断是否是回文串
    static private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
