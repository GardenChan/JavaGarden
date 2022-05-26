package dream.high_frequency;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/20 0:03
 * author: Garden Chan
 * description: NC32 求平方根
 */
public class Sqrt {
    /**
     *
     * @param x int整型
     * @return int整型
     */
    public int sqrt (int x) {
        // write code here
        if(x==1) return 1;
        int left = 1,right = x; //左右边界
        while(right>=left){
            int mid = (right+left)/2;  //中间值
            if(mid<=x/mid&&(mid+1)>x/(mid+1)) return mid; // mid*mid可能溢出，所以用除法
            if(mid>x/mid) right = mid -1;
            else  left = mid +1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(15));
    }
}
