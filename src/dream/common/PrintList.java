package dream.common;

/**
 * projectName:Java-Garden
 * see:dream.common
 * createTime:2021/8/1 1:40
 * author: Garden Chan
 * description: 打印链表
 */
public class PrintList {
    public static void print(ListNode head){
        if (head==null) System.out.println("link list is null...");
        System.out.print("print link list: ");
        while (head!=null){
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
