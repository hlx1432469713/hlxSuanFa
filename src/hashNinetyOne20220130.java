import java.util.*;

/**
 *date：2022-01-30
 *
 * message :  有效的字母异位词
 *
 * work : 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * 字母异位词   简意为两字符串长度相同，字母相同，顺序不同。
 */
public class hashNinetyOne20220130 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            String t = scanner.next();
            boolean flag = isAnagram(s,t);
            System.out.println(flag);
        }
    }
    static public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character,Integer> mapsS = new HashMap<>();
        Map<Character,Integer> mapsT = new HashMap<>();
        for (int i = 0;i < s.length();i++) {
            if (mapsS.get(s.charAt(i))!=null){
                mapsS.put(s.charAt(i), mapsS.get(s.charAt(i))+1);
            }else {
                mapsS.put(s.charAt(i),1);
            }
            if (mapsT.get(t.charAt(i))!=null){
                mapsT.put(t.charAt(i), mapsT.get(t.charAt(i))+1);
            }else {
                mapsT.put(t.charAt(i),1);
            }
        }
        for(Character key:mapsS.keySet()){
            if (mapsT.get(key) == null)
                return false;
            if (mapsS.get(key).intValue() != mapsT.get(key).intValue())
                return false;
        }
        return true;
    }

    static public boolean isAnagram2(String s,String t){
        if (s.length() != t.length())
            return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars,chart);
    }

    static public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character,Integer> mapsS = new HashMap<>();

        for (int i = 0;i < s.length();i++) {
           mapsS.put(s.charAt(i),mapsS.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0;i < t.length();i++) {
            mapsS.put(t.charAt(i),mapsS.getOrDefault(t.charAt(i),0) - 1);
            if (mapsS.get(t.charAt(i)) < 0)
                return false;
        }
        return true;

    }

    static public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] list = new int[26];

        for (int i = 0;i < s.length();i++) {
           list[s.charAt(i) - 'a']  += 1;
        }
        for (int i = 0;i < t.length();i++) {
            list[t.charAt(i) - 'a'] -= 1;
        }
        for (int i : list){
            if (i < 0)
                return false;
        }
        return true;

    }
}
