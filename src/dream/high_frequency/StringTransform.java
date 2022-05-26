package dream.high_frequency;

import java.util.Stack;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 16:56
 * author: Jiading chen
 * description: NC89 字符串变形
 */
public class StringTransform {
    public String trans(String s, int n) {
        //空格划分成数组
        String[] arr =  s.split(" ",-1);
        //数组元素入栈
        Stack<String> stack = new Stack<String>();
        for(String str:arr){
            stack.push(str);
        }
        //逆序出栈
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        //去除最后一个空格
        sb.deleteCharAt(sb.length()-1);
        //大小写互换
        return reverse(sb.toString());
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                temp = (char)(temp-32);
            }else if(temp >= 'A' && temp <= 'Z') {
                temp = (char)(temp+32);
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringTransform stringTransform = new StringTransform();
        String nowCoder = stringTransform.trans("h i ", 8);
        System.out.println(nowCoder);
    }
}
