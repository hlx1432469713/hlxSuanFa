
/**
 *date：2022-04-28
 *
 * message :剑指 Offer 25. 合并两个排序的链表
 *
 * work :输输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 */
public class NodeTwoHundredNinetyNine20220428 {
    public static void main(String[] args){}

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode cur = pre;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                pre.next = l2;
                l2 = l2.next;
            }else{
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        if(l1 != null) pre.next = l1;
        if(l2 != null) pre.next = l2;
        return cur.next;
    }
}
