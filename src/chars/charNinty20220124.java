package chars;

import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Scanner;

 /**
  *date：2022-01-24
  *
  * message ： 数组形式的整数加法
  *
  * work:对于非负整数X而言，X的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果X = 1231，那么其数组形式为[1,2,3,1]。
  *
  * 给定非负整数 X 的数组形式A，返回整数X+K的数组形式。
  */
 public class charNinty20220124 {
     public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
         while(scanner.hasNext()){
             int n = scanner.nextInt();
             int[] num = new int[n];
             for(int i = 0;i < n;i++)
                 num[i] = scanner.nextInt();
             int k = scanner.nextInt();
             List<Integer> list = addToArrayForm(num,k);
             for (int j = 0;j < list.size();j++)
                 System.out.print(list.get(j) + " ");
         }


     }
     static public List<Integer> addToArrayForm(int[] num, int k) {
         //list转换成LinkedList
         LinkedList<Integer> list = new LinkedList<>();
         int lengthNum = num.length;
         String strK = String.valueOf(k);
         int lengthStrK = strK.length();
         int index = 0;
         while(lengthNum > 0 || lengthStrK > 0){
             if (lengthNum > 0){
                 int nums = num[lengthNum - 1];
                 index += nums;
                 lengthNum--;
             }
             if (lengthStrK > 0){
                 index += k%10;
                 k = k / 10;
                 lengthStrK--;
             }
             list.addFirst(index%10);
             if (index < 10){
                 index = 0;
             }else {
                 index =  1;
             }
         }
         if (index ==  1)
             list.addFirst(1);
         return list;
     }



 }
