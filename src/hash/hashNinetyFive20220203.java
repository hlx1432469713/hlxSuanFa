package hash;

import java.util.Scanner;

/**
 *date：2022-02-03
 *
 * message :  赎金信
 *
 * work : 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 */
public class hashNinetyFive20220203 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String ransomNote = scanner.next();
            String magazine = scanner.next();
            boolean result = canConstruct(ransomNote,magazine);
            System.out.println(result);
        }
    }

    static public boolean canConstruct(String ransomNote, String magazine) {
        int[] flag = new int[26];
        char[] magazineStr = magazine.toCharArray();
        char[] ransomNoteStr = ransomNote.toCharArray();
        for (int i = 0;i < magazineStr.length;i++)
            flag[magazineStr[i] - 'a']++;
        for (int i = 0;i < ransomNoteStr.length;i++) {
            flag[ransomNoteStr[i] - 'a']--;
            if (flag[ransomNoteStr[i] - 'a'] < 0)
                return false;
        }
        return true;
    }
}
