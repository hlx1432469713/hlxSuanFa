package hash;

import java.util.LinkedList;
import java.util.Queue;

/**
 *date：2022-05-07
 *
 * message :433. 最小基因变化
 *
 * work :基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 *
 * 假设我们需要调查从基因序列start 变为 end 所发生的基因变化。
 * 一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 *
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，
 * 请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 *
 * 注意：起始基因序列start 默认是有效的，但是它并不一定会出现在基因库中。
 */
public class hashThreeHundredTwenty20220507 {
    public static void main(String[] args){
        String start = "AAAAACCC";
        String end ="AACCCCCC";
        String[] bank = {"AAACCCCG","AAAAACCG","AAAACCCG","AACCCCCG","AACCCCCC"};
        int result = minMutation(start,end,bank);

    }
    static public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int sum = 0;
        if(start.equals(end))
            return sum;
        while(!queue.isEmpty()){
            int index = queue.size();
            sum++;
            for(int j = 0;j < index;j++){
                String r = queue.poll();
                for(int i = 0;i < bank.length;i++){
                    if(bank[i] != "" &&getString(r,bank[i])){
                        if(bank[i].equals(end))
                            return sum;
                        queue.add(bank[i]);
                        bank[i] = "";
                    }
                }
            }
        }
        return -1;
    }

    static public boolean getString(String s1,String s2){
        int sum = 0;
        for(int i = 0;i < s1.length();i++)
            if(s1.charAt(i) != s2.charAt(i))
                sum++;
        return  sum == 1;
    }
}
