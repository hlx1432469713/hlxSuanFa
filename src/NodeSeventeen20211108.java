import java.util.Scanner;

/**
 *date：2021-11-08
 *
 * message ：链表（ 删除链表的倒数第 N 个结点）
 *
 * work:给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
        进阶：你能尝试使用一趟扫描实现吗？。
 */
public class NodeSeventeen20211108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = new ListNode();
        int num = scanner.nextInt();
        for(int i = 0;i < num;i++)
            head.add(scanner.nextInt());
        int n = scanner.nextInt();
        ListNode result = removeNthFromEnd(head.next,n);
        result.print();

    }

   static public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        //虚拟头节点
        ListNode first = new ListNode();
        first.next = head;

        ListNode pre = head;//慢指针
        ListNode cur = head;//快指针
        ListNode flag = first;//保留待删除节点的上一个节点

       //进行快指针移动
        for(int i = 1 ;i < n;i++){
            cur = cur.next;
        }
        //进行快慢指针移动
        while(cur.next!=null){
            cur = cur.next;
            pre = pre.next;
            flag = flag.next;
        }
        //删除指定节点
        flag.next = pre.next;

        return first.next;

   }

}
