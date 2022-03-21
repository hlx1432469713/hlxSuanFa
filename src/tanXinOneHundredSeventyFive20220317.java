import java.util.Arrays;
import java.util.Scanner;

/**
 *date：2022-03-17
 *
 * message ：179. 最大数
 *
 * work :给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class tanXinOneHundredSeventyFive20220317 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n;i++)
                nums[i] = scanner.nextInt();
            String result = largestNumber(nums);
            System.out.println(result);
        }

    }

    static public String largestNumber(int[] nums) {
        String [] list = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(list,(a,b) -> {
           String s1 = a + b;
           String s2 = b + a;
           return s2.compareTo(s1);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }
        int k = 0;
        //前导0处理，只能保留1个0
        while(k < stringBuilder.length() - 1 && stringBuilder.charAt(k) == '0')
            k++;

        return String.valueOf(stringBuilder.substring(k));


    }
}
