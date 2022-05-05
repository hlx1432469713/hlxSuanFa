import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *date：2022-05-01
 *
 * message :148. 排序链表
 *
 * work :给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 */
public class NodeThreeHundredEight20220501 {
    public static void main(String[] args){}
    public ListNode sortList1(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = head;
        int length = 0;
        while(pre != null ){
            pre = pre.next;
            length++;
        }
        int[] nums = new int[length];
        pre = head;
        int index = 0;
        while(pre != null ){
            nums[index++] = pre.val;
            pre = pre.next;
        }
        //Arrays.sort(nums);
        sort(nums,0,length - 1);
        ListNode node = new ListNode(nums[0]);
        ListNode cur = node;
        for(int i = 1;i < nums.length;i++){
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return node;
    }
    static public void sort(int[] nums,int start,int end){
        if(start < end){
            int mid = start + (end - start) / 2;
            sort(nums,start,mid);
            sort(nums,mid + 1,end);
            merge(nums,start,end);
        }

    }
    static public void merge(int[] nums,int left ,int right){
        int[] tmp = new int[nums.length];
        int mid = left + (right - left) / 2;
        int p1 = left;
        int p2 = mid + 1;
        int k = left;
        while(p1 <= mid && p2 <= right){
            if(nums[p1] <= nums[p2]){
                tmp[k++] = nums[p1++];
            }else{
                tmp[k++] = nums[p2++];
            }
        }
        while(p1 <= mid)
            tmp[k++] = nums[p1++];
        while(p2 <= right)
            tmp[k++] = nums[p2++];
        for(int i = left;i <= right;i++)
            nums[i] = tmp[i];
    }

    //在链表上直接进行归并排序---找中心节点
    public ListNode sortList(ListNode head) {
       if(head == null || head.next == null)
           return head;
       ListNode mid = getMidNode(head);
       ListNode rightNode = mid.next;
       mid.next = null;
       ListNode left = sortList(head);
       ListNode right = sortList(rightNode);
       return merger(left,right);
    }

    //寻找链表的中心点
    public ListNode getMidNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next.next;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //合并两个有序列表
    public ListNode merger(ListNode left ,ListNode right){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while(left!=null && right != null){
            if(left.val <= right.val){
                cur.next = new ListNode(left.val);
                left = left.next;
            }else{
                cur.next = new ListNode(right.val);
                right = right.next;
            }
            cur= cur.next;
        }
       cur.next = left !=null ? left : right;
        return pre.next;
    }
}
