/**
 *date：2022-04-24
 *
 * message :剑指 Offer 06. 从尾到头打印链表
 *
 * work :输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 */
public class NodeTwoHundredEightyFour20220424 {
    public static void main(String[] args){}
    public int[] reversePrint(ListNode head) {
        ListNode pre = head;
        int sum = 0;
        while(pre != null){
            sum++;
            pre = pre.next;
        }
        ListNode cur = head;
        int[] result = new int[sum];
        while(cur != null){
            result[sum - 1] = cur.val;
            cur = cur.next;
            sum--;
        }
        return result;

    }
}
