import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2022-02-10
 *
 * message :  最简分数
 *
 * work : 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。
 * 分数可以以 任意 顺序返回。
 *
 *
 */
public class charOneHundredOne20220210 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            List<String> str = simplifiedFractions(n);
            for (String s : str)
                System.out.print(s + "  ");
        }

    }
    static public List<String> simplifiedFractions(int n) {
        List<String> str = new ArrayList<>();
        if (n <= 1)
            return str;
        for(int i = 2;i <= n;i++){
            str.add("1/"+i);
            for (int j = 2;j <= i;j++){;
                int m = i,h = j;
                int x = m % h;
                while (x !=0){
                     m = h;
                     h = x;
                     x = m % h;
                }
                if (h != 1)
                    continue;
                str.add(j + "/" + i);
            }
        }
        return str;
    }
}
