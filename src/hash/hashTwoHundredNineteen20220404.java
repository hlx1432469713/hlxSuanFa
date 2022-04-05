package hash;


import java.util.*;

/**
 *date：2022-04-04
 *
 * message :剑指 Offer II 015. 字符串中的所有变位词
 *
 * work : 给定两个字符串s和p，找到s中所有 p 的变位词的子串，
 * 返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 变位词 指字母相同，但排列不同的字符串。
 *
 */
public class hashTwoHundredNineteen20220404 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.next();
            String p = scanner.next();
            List<Integer> result = findAnagrams(s,p);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result + " ");
            }
        }
    }
    static  public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length())
            return list;
        int slength = s.length();
        int plength = p.length();
        int[] plist = new int[26];
        for (int i = 0;i < plength;i++){
            plist[p.charAt(i) - 'a']++;
            plist[s.charAt(i) - 'a']--;
        }
        if (getNum(plist)){
            list.add(0);
        }
        for (int i = plength;i < slength;i++){
            plist[s.charAt(i) - 'a']--;
            plist[s.charAt(i - plength) - 'a']++;
            if (getNum(plist)){
                list.add(i -plength + 1);
            }
        }
        return list;
    }

    static public boolean getNum(int[] list){
        for (int i : list)
            if (i != 0)
                return false;
        return true;
    }
}
