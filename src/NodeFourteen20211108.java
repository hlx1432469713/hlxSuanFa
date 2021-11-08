import java.util.Scanner;

/**
 *date：2021-11-08
 *
 * message ：链表（翻转链表）
 *
 * work:给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class NodeFourteen20211108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = new ListNode();
        int n = scanner.nextInt();
        for(int i = 0;i < n;i++)
            head.add(scanner.nextInt());
        //ListNode result = reverseList(head.next);
        ListNode result1 = reverseList(head.next);
       // result.print();
        result1.print();

    }
    //双指针法
    static  public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }

    //递归方法
    private ListNode reverse(ListNode prev, ListNode cur) {
       if(cur == null)
           return prev;
       ListNode temp = cur.next;
       cur.next = prev;
       prev = cur;
       cur = temp;
       return reverse(prev,cur);
    }
}
