import java.util.List;
import java.util.Scanner;

/**
 *date：2021-11-04
 *
 * message ：链表（移除链表元素）
 *
 * work:存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
        返回同样按升序排列的结果链表。
 *注：是一个升序列表
 */
public class NodeThirteen20211104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode node = new ListNode(-1);
        int num = scanner.nextInt();
        for(int i = 0; i < num;i++)
            node.add(scanner.nextInt());
        ListNode result = deleteDuplicates(node.next);
        result.print();
    }
    static public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode cur = head;
        ListNode pre = head.next;
        while(pre!=null){
            if(cur.val == pre.val){
                cur.next = pre.next;
            }else {
                cur = cur.next;
            }
            pre = pre.next;
        }
        return head;

    }

}
