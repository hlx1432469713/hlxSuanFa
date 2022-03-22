import java.util.Scanner;

/**
 *date：2022-03-22
 *
 * message ：2038. 如果相邻两个颜色均相同则删除当前颜色
 *
 * work :总共有 n个颜色片段排成一列，每个颜色片段要么是'A'要么是'B'。给你一个长度为n的字符串colors，
 * 其中colors[i]表示第i个颜色片段的颜色。
 *
 * Alice 和 Bob 在玩一个游戏，他们 轮流从这个字符串中删除颜色。Alice 先手。
 *
 * 如果一个颜色片段为 'A'且 相邻两个颜色都是颜色 'A'，
 * 那么 Alice 可以删除该颜色片段。Alice不可以删除任何颜色'B'片段。
 *
 * 如果一个颜色片段为 'B'且 相邻两个颜色都是颜色 'B'，那么 Bob 可以删除该颜色片段。
 * Bob 不可以删除任何颜色 'A'片段。
 *
 * Alice 和 Bob 不能字符串两端删除颜色片段。
 *
 * 如果其中一人无法继续操作，则该玩家 输掉游戏且另一玩家 胜。
 * 假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回true，否则 Bob 获胜，返回false。
 *
 *
 */
public class tanXinOneHundredEightyFive20220322 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.next();
            boolean i = winnerOfGame(s);
            System.out.println(i);
        }

    }

    //计算A可删除的个数AmaxLength和B可删除的个数BmaxLength
    //只有当AmaxLength > BmaxLength时Alice才会获胜，否则就是Bob获胜
    static  public boolean winnerOfGame(String colors) {
        if (colors.length() <= 2)
            return false;
        int AmaxLength = 1;
        int BmaxLength = 1;
        char[] list = colors.toCharArray();
        for (int i = 1; i < list.length - 1 ; i++) {
            if (list[i] == 'A'){
                if (list[i -1] == 'A'&& list[i + 1] == 'A')
                    AmaxLength++;
            }else {
                if (list[i -1] == 'B'&& list[i + 1] == 'B')
                    BmaxLength++;
            }
        }
        if (AmaxLength <= BmaxLength)
            return false;
        else
            return true;
    }
}
