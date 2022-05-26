package dream.high_frequency.stack;

import java.util.Stack;

/**
 * projectName:java-garden
 * see:dream.bytedance.stack
 * createTime:2021/10/3 17:32
 * author: Jiading chen
 * description: 用一个辅助栈实现另一个栈的排序
 */
public class SortedStack {
    public static void sortStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            int pop = stack.pop();
            while (!help.isEmpty() && help.peek() < pop) {
                stack.push(help.pop());
            }
            help.push(pop);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(8);
        stack.push(9);
        stack.push(1);
        stack.push(12);
        stack.push(22);
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}
