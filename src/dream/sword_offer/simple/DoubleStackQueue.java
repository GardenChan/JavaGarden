package dream.sword_offer.simple;

import java.util.Stack;

/**
 * projectName:java-garden
 * see:dream.sword_offer.simple
 * createTime:2021/9/10 10:36
 * author: Jiading chen
 * description: 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DoubleStackQueue {
    Stack<Integer> appendStack;
    Stack<Integer> deleteStack;
    int size;

    public DoubleStackQueue() {
        this.appendStack = new Stack<Integer>();
        this.deleteStack = new Stack<Integer>();
        size = 0;
    }

    public void appendTail(int value) {
        appendStack.push(value);
        size++;
    }

    public int deleteHead() {
        if (size==0) return -1;
        if (deleteStack.empty()) {
            while (!appendStack.empty()) {
                deleteStack.push(appendStack.pop());
            }
        }
        Integer pop = deleteStack.pop();
        size--;
        return pop;
    }
}
