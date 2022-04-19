
import java.util.HashSet;
import java.util.Set;

/**
 *date：2022-04-19
 *
 * message :160. 相交链表
 *
 * work :给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 */
public class NodeTwoHundredSixty20220419 {
    public static void main(String[] args){}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headB == null || headB == null)
            return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            if(pA == null) pA = headB;
            else pA = pA.next;
            if(pB == null) pB = headA;
            else pB = pB.next;
        }
        return pA;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode pre = headA;
        ListNode tmp = headB;
        while(pre != null){
            set.add(pre);
            pre = pre.next;
        }
        while(tmp !=null){
            if(set.contains(tmp))
                return tmp;
            tmp = tmp.next;
        }
        return null;

    }
}
