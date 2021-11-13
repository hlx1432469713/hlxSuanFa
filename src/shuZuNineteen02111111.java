import java.util.HashMap;
import java.util.Scanner;

import static javax.swing.UIManager.put;

/**
 *date：2021-11-11
 *
 * message ：滑动窗口
 *
 * work:在一排树中，第 i 棵树产生tree[i] 型的水果。你可以从你选择的任何树开始，然后重复执行以下步骤：
 *
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 *
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 *
 * 用这个程序你能收集的水果树的最大总量是多少？

 *
 *             这个题目暂时没有做出来，下面只是正确答案
 */
public class shuZuNineteen02111111 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int nums[] = new int[num];
        for(int i = 0;i<num;i++)
            nums[i] = scanner.nextInt();
        int result = totalFruit(nums);
        System.out.println(result);


    }
    //滑动窗口
    static public int totalFruit(int[] fruits) {
        int ans = 0, i = 0;
        Counter count = new Counter();
        for (int j = 0; j < fruits.length; ++j) {
            count.add(fruits[j], 1);
            while (count.size() >= 3) {
                count.add(fruits[i], -1);
                if (count.get(fruits[i]) == 0)
                    count.remove(fruits[i]);
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
    static class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        public void add(int k, int v) {
            put(k, get(k) + v);
        }
    }



}
