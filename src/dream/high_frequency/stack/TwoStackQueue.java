package dream.high_frequency.stack;

import java.util.Stack;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/9 0:08
 * author: Garden Chan
 * description: NC76 用两个栈实现队列
 */
public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (!stack2.isEmpty()) {
            transferTo(stack2, stack1);
        }
        stack1.push(node);
    }

    public int pop() {
        if (!stack1.isEmpty()) {
            transferTo(stack1, stack2);
        }
        return stack2.pop();
    }

    private void transferTo(Stack<Integer> from, Stack<Integer> to) {
        if (!from.isEmpty()){
            int size = from.size();
            for (int i = 0; i < size; i++) {
                to.push(from.pop());
            }
        }
    }
}
