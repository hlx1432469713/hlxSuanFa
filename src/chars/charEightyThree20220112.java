package chars;

import java.util.Scanner;

/**
 *date：2022-01-05
 *
 * message ：最长公共前缀
 *
 * work:编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。

 */
public class charEightyThree20220112 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] strs = new String[n];
            for(int i = 0;i < n;i++)
                strs[i] = scanner.next();
            String str = longestCommonPrefix(strs);
            System.out.println(str + "");
        }

    }
    static  public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 )
            return "";
        if (strs.length == 1 )
            return strs[0];
        String str = strs[0];
        for(int i = 1;i < strs.length;i++){
            if (str.length() == 0)
                break;
            if (strs[i].length() == 0){
                str = "";
                break;
            }
            for(int j = 0;j < Math.min(strs[i].length(),str.length());j++){
                if (str.charAt(j) != strs[i].charAt(j)){
                    str = str.substring(0,j);
                    break;
                }
                str = str.substring(0,Math.min(strs[i].length(),str.length()));
            }
        }
        return str;

    }

   // public boolean startsWith(String prefix, int toffset) {
//        char ta[] = value;
//        int to = toffset;
//        char pa[] = prefix.value;
//        int po = 0;
//        int pc = prefix.value.length;
//        // Note: toffset might be near -1>>>1.
//        if ((toffset < 0) || (toffset > value.length - pc)) {
//            return false;
//        }
//        while (--pc >= 0) {
//            if (ta[to++] != pa[po++]) {
//                return false;
//            }
//        }
//        return true;
   // }
}
