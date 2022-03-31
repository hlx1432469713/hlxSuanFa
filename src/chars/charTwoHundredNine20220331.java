package chars;


import java.util.ArrayList;
import java.util.List;

/**
 *date：2022-03-31
 *
 * message : 728. 自除数
 *
 * work :自除数是指可以被它包含的每一位数整除的数。
 *
 * 例如，128 是一个 自除数 ，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 *
 * 给定两个整数left和right ，返回一个列表，列表的元素是范围[left, right]内所有的 自除数 。
 *
 */
public class charTwoHundredNine20220331 {
    public static void main(String args[]){}


    static  public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left;i<=right;i++){
            if(isDividingNum(i))
                list.add(i);
        }
        return list;
    }
    static public boolean isDividingNum(int num){
        int flag = num;
        int x = 0;
        while(num > 0){
            x = num % 10;
            if(x == 0 || flag % x != 0)
                return false;
            num = num / 10;
        }
        return true;
    }
}
