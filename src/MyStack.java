import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈（后进先出）
 */
public class MyStack {
    Queue<Integer> queue1;//主队列
    Queue<Integer> queue2;//辅助队列
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    //将元素 x 压入栈顶。
    public void push(int x) {
        queue2.offer(x);//==add
        //当主队列1不为空的时候
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;
    }

    //移除并返回栈顶元素
    public int pop() {
        return queue1.poll();
    }

    //返回栈顶元素
    public int top() {
        return queue1.peek();
    }

    // 如果栈是空的，返回 true ；否则，返回 false 。
    public boolean empty() {
        return queue1.isEmpty();
    }
}
