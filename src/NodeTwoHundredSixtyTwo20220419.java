import java.util.List;
import java.util.Stack;

/**
 *date：2022-04-19
 *
 * message :143. 重排链表
 *
 * work :给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class NodeTwoHundredSixtyTwo20220419 {
    public static void main(String[] args){}
    //方法一：用栈的方法存储后 leng / 2；
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pre = head;
        ListNode cur = head;
        ListNode tmp = head;
        int length = 0;
        int flag = 0;
        while(pre != null){
            pre = pre.next;
            length++;
        }
        while(cur !=null){
            flag++;
            if(flag > length / 2 + length % 2){
                stack.push(cur);
            }
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            ListNode index = tmp.next;
            tmp.next = node;
            node.next = index;
            tmp = index;
        }
        tmp.next = null;
    }
    //方法二：1.先找到中间节点 2.对中间节点后面进行反转  3.将两部分链表进行合并
    public void reorderList2(ListNode head) {
        //1.找中间节点
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.对中间节点后面进行反转
        ListNode tmp = slow;
        ListNode pre = null;
        while(tmp != null){
            ListNode flag = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = flag;
        }
        // 3.将两部分链表进行合并
        ListNode cur = head;
        while(pre != null){
            ListNode a = cur.next;
            ListNode b = pre.next;
            cur.next = pre;
            pre.next = a;
            pre = b;
            cur = a;
        }
        if(cur != null)
            cur.next = null;
    }

}
