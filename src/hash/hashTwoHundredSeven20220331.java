package hash;


/**
 *date：2022-03-31
 *
 * message :  剑指 Offer II 014. 字符串中的变位词
 *
 * work :给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *
 *
 */
public class hashTwoHundredSeven20220331 {
    public static void main(String args[]){}

    /**
     * 变位词的字母数量的出现次数相同。
     * 使用长度为26的数组记录s1中的字母出现次数，在对应位置+1
     * 使用长度与s1相等的滑动窗口在s2中判断子字符串是否为变位词，方法是在对应位置-1，判断数组是否全为0；
     * 窗口向前滑动，头部移除的字母重新+1，新加入的字母-1，再次判断。
     *
     * @param s1
     * @param s2
     * @return
     */
    static public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] num = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            num[s1.charAt(i) - 'a'] += 1;
            //初始化将滑动窗口装满
            num[s2.charAt(i) - 'a'] -= 1;

        }
        if (isAllZero(num))
            return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            num[s2.charAt(i) - 'a']--;
            //维护滑动窗口的长度
            num[s2.charAt(i - s1.length()) - 'a']++;
            if (isAllZero(num))
                return true;
        }
        return false;
    }
    static private boolean isAllZero(int[] num){
        for (int i : num) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
