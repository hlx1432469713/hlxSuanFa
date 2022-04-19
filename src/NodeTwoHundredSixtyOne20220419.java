
import java.util.HashSet;
import java.util.Set;

/**
 *date：2022-04-19
 *
 * message :876. 链表的中间结点
 *
 * work :给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class NodeTwoHundredSixtyOne20220419 {
    public static void main(String[] args){}
    public ListNode middleNode(ListNode head) {
        //慢指针走一步，快指针走两步
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
