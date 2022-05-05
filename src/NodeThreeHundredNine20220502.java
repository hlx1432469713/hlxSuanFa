import java.util.PriorityQueue;

/**
 *date：2022-05-02
 *
 * message :23. 合并K个升序链表
 *
 * work :给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 */
public class NodeThreeHundredNine20220502 {
    public static void main(String[] args){}
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 )
            return null;
        return sort(lists,0,lists.length - 1);

    }
    //采用归并排序
    public ListNode sort(ListNode[] lists,int start,int end){
        if(start == end)
            return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = sort(lists,start,mid);
        ListNode right = sort(lists,mid + 1,end);
        return mergeTwo(left,right);
    }

    public ListNode mergeTwo(ListNode l1,ListNode l2){
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ?l1 :l2;
        return result.next;
    }

    //采用小根堆
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0;i < lists.length;i++){
            ListNode tmp = lists[i];
            while(tmp != null){
                queue.add(tmp.val);
                tmp = tmp.next;
            }
        }
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while(!queue.isEmpty()){
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }
        return root.next;
    }
}
