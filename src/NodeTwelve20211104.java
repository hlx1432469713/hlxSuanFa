import java.util.Scanner;

/**
 *date：2021-11-04
 *
 * message ：链表（移除链表元素）
 *
 * work:给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 *
 */
public class NodeTwelve20211104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode node = new ListNode();
        int num = scanner.nextInt();
        for(int i = 0; i < num; i++)
            node.add(scanner.nextInt());
        ListNode result = removeElements(node,0);
        result.print();

    }
    //移除链表相对应的值
    static public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
       ListNode first = new ListNode(-1,head);
       ListNode pre = first;
       ListNode cur = head;
       while(cur!=null){
           if(cur.val == val){
               pre.next = cur.next;
           }else{
               pre = cur;
           }
           cur = cur.next;
       }

       return first.next;
    }

}
