import java.util.Scanner;
import java.util.Stack;

/**
 *date：2022-04-07
 *
 * message : 21. 合并两个有序链表
 *
 * work :将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 */
public class NodeTwoHundredThirty20220407 {
    public static void main(String[] args){}
    static public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(-1);
        ListNode pre = listNode;
        ListNode left = list1;
        ListNode right = list2;
        while(left != null && right !=null){
            if (left.val < right.val){
                pre.next = left;
                left = left.next;
            }else{
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        if (left == null)
            pre.next = right;
        if (right == null)
            pre.next = left;
        return listNode.next;
    }
}
