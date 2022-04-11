package chars;

import java.util.List;

/**
 *date：2022-04-11
 *
 * message :796. 旋转字符串
 *
 * work :给定两个字符串, s和goal。如果在若干次旋转操作之后，s能变成goal，
 * 那么返回true。
 *
 * s的 旋转操作 就是将s 最左边的字符移动到最右边。
 *
 * 例如, 若s = 'abcde'，在旋转一次之后结果就是'bcdea'。
 */
public class charTwoHundredThirtyTwo20220411 {
    public static void main(String[] args){}
    static  public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        String s1 = s + s;
        if(s1.contains(goal))
            return true;
        else
            return false;
    }
}
