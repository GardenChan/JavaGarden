package dream.high_frequency.stack;

import java.util.Stack;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/20 0:08
 * author: Garden Chan
 * description: NC90 包含min函数的栈
 */

public class MinStack {
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> minimal = new Stack<>();

    public void push(int node) {
        normal.push(node);
        if (minimal.size()==0){
            minimal.push(node);
        }else {
            if (minimal.peek()<node){
                minimal.push(minimal.peek());
            }else {
                minimal.push(node);
            }
        }
    }

    public void pop() {
        normal.pop();
        minimal.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return minimal.peek();
    }
}
