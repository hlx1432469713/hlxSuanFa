import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2021-11-08
 *
 * message ：链表（两两交换链表中的节点）
 *
 * work:给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class NodeSixteen20211108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = new ListNode();
        int num = scanner.nextInt();
        for(int i = 0;i < num;i++)
            head.add(scanner.nextInt());
        ListNode result = swapPairs(head.next);
        result.print();

    }

    //添加头节点--双指针
    static public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur = head;
        ListNode temp = null;
        ListNode flag = pre;
        while(cur!=null && cur.next != null){
            temp = cur.next;
            flag.next = temp;
            cur.next = temp.next;
            temp.next = cur;
            flag =cur;
            cur = cur.next;
        }
        return pre.next;
    }
    //递归来写
    static  ListNode swapPairsNew(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode newNode = swapPairsNew(next.next);
        next.next = head;
        head.next = newNode;
        return next;
    }
}
