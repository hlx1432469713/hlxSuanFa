import java.util.Stack;

/**
 * 用两个栈实现队列（先进先出）
 */
public class MyQueue {
    Stack<Integer> in ;//输入栈
    Stack<Integer> out ;//输出栈

    //构造函数  --初始化
    public MyQueue(){
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    //入队列-----将元素 x 推到队列的末尾
    public void push(int x){
        in.push(x);
    }

    //出队列-----从队列的开头移除并返回元素
    public int pop(){
        dumpIn();
        return out.pop();

    }

    //返回队列开头的元素
    public int peek(){
        dumpIn();
        return out.peek();
    }

    // 如果队列为空，返回 true ；否则，返回 false
    public boolean empty(){
        return in.isEmpty() && out.isEmpty();
    }

    //如果出栈为空，那么将入栈的元素全部放到出栈中（这样入栈的元素顺序就发生了倒转，从而符合队列的先进先出原则！）
    private void dumpIn(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }
}
