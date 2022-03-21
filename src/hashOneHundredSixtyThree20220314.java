import java.util.*;

/**
 *date：2022-03-14
 *
 * message :  599. 两个列表的最小索引总和
 *
 * work :  假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 *
 */
public class hashOneHundredSixtyThree20220314 {
    public static void main(String args[]){}
    static   public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int indexSum = 0;
        for(int i = 0;i < list1.length;i++){
            map.put(list1[i],i);
        }
        for(int i = 0;i < list2.length;i++){
            if(map.containsKey(list2[i])){
                indexSum = map.get(list2[i]) + i;
                if(indexSum < min){
                    list.clear();
                    min = indexSum;
                    list.add(list2[i]);
                }else if(indexSum == min)
                    list.add(list2[i]);
            }
        }
        return list.toArray(new String[0]);
    }

}
