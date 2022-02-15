import java.util.*;

/**
 *date：2022-02-15
 *
 * message :  矩阵中的幸运数
 *
 * work : 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 */
public class shuZuOneHundredEighteen20220215 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] nums = new int[m][n];
            for (int i = 0;i < m;i++)
                for (int j = 0;j < n;j++)
                    nums[i][j] = scanner.nextInt();
            List<Integer> result = luckyNumbers(nums);
            for (Integer i : result)
                System.out.print(i + " ");
        }

    }

    static public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i <matrix.length;i++){
            int min = matrix[i][0];
            int index = 0;
            for (int j = 1;j < matrix[i].length;j++){
                if (min > matrix[i][j]){
                    min = matrix[i][j];
                    index = j;
                }
            }
            map.put(min,index);
        }
        for(Integer j : map.keySet()){
            int max = matrix[0][map.get(j)];
            for (int i = 1;i < matrix.length;i++){
                if (max < matrix[i][map.get(j)]){
                    max = matrix[i][map.get(j)];
                }
            }
            if (j == max)
                list.add(max);
        }
        return list;
    }
}
