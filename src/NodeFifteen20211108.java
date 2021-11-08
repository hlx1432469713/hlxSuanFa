import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *date：2021-11-08
 *
 * message ：链表（回文链表）
 *
 * work:给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class NodeFifteen20211108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode head = new ListNode();
        int num =scanner.nextInt();
        for(int i = 0;i < num;i++)
            head.add(scanner.nextInt());

        //boolean result = isPalindrome(head.next);
        boolean result = isPalindromeNew(head.next);
        System.out.println(result);

    }
    //自己方法：将链表节点值存入数组，并对链表进行翻转，然后比对数组和链表中的值是否相同
    static public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        List<Integer> first = new ArrayList<>();
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur!=null){
            first.add(cur.val);
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
       int index = 0;
        while(pre!=null){
            if(pre.val != first.get(index))
                return false;
            pre =pre.next;
            index++;
        }
        return true;
    }

    //快慢指针
    static public boolean isPalindromeNew(ListNode head) {
      if(head == null || head.next == null)
          return true;
      ListNode fast = head,slow= head,pre = head;
      ListNode prepre = null;
      while(fast != null && fast.next != null){
          pre = slow;
          //注意顺序：先进行快慢指针的变换，然后在进行翻转
          fast = fast.next.next;//快指针每次走两步
          slow = slow.next;//慢指针每次走一步
          pre.next = prepre;
          prepre = pre;
      }
      //当fast!=null 代表此时链表长度为奇数，而此时慢指针刚好在链表中间元素
      if(fast !=null)
          slow = slow.next;

      while(pre != null){
          if(pre.val != slow.val)
              return false;
          pre = pre.next;
          slow = slow.next;
      }
      return true;
    }


}
