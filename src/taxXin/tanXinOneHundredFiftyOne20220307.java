package taxXin;

import java.util.*;

/**
 *date：2022-03-04
 *
 * message ：406. 根据身高重建队列
 * work :假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 *
 */
public class tanXinOneHundredFiftyOne20220307 {
    public static void main(String[] args){}


    //两个维度的，需要先确定一个维度的顺序，然后在根据另外一个维度进行数据的操作
    static public int[][] reconstructQueue(int[][] people){
        //首先根据身高people[][0] 进行从大到小排序，如果身高相等 则按people[][1] 从小到大排列
        Arrays.sort(people,(a,b)->{
            if(a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1],person);
        }
        return list.toArray(new int[people.length][]);
    }
}
