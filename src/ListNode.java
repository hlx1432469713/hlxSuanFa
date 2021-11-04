/**
 * 初始化链表头节点
 */
public class ListNode {
    int val;//链表节点指向的值
    ListNode next = null;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val , ListNode next){
        this.val = val;
        this.next = next;
    }

    //添加新的节点
    public void add(int newVal){
        ListNode newNode = new ListNode(newVal);
        if(this.next == null)
            this.next = newNode;
        else
            this.next.add(newVal);
    }

    //打印链表
    public void print(){
        System.out.print(this.val);
        if(this.next != null){
            System.out.print("-->");
            this.next.print();
        }
    }
}
