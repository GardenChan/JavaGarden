package dream.high_frequency.stack;

import java.util.Stack;

/**
 * projectName:java-garden
 * see:dream.bytedance.stack
 * createTime:2021/10/3 17:21
 * author: Jiading chen
 * description: 仅用递归函数和栈操作逆序一个栈
 */
public class ReverseStack {
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()) return;
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}
