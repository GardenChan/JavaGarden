package dream.high_frequency;

import java.util.PriorityQueue;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 21:04
 * author: Jiading chen
 * description: NC131 随时找到数据流的中位数
 */
public class FlowMedian {
    /**
     * the medians
     * @param operations int整型二维数组 ops
     * @return double浮点型一维数组
     */
    public double[] flowmedian (int[][] operations) {
        //初始化结果数组
        int len=0;
        for(int[] opera:operations){
            if(opera[0]==2){
                len++;
            }
        }
        double[] res=new double[len];

        //初始化MedianHolder类
        MedianHolder median=new MedianHolder();
        int id=0;
        for(int[] opera:operations){
            //如果opt=1，则加入到结构中
            if(opera[0]==1){
                median.addNum(opera[1]);
            }
            //如果opt=2，则取出当前中位数
            else{
                res[id++]=median.findMedian();
            }
        }

        return res;
    }

    class MedianHolder{
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        MedianHolder() {
            min=new PriorityQueue<>();
            max=new PriorityQueue<>((o1,o2)->o2-o1);
        }

        //添加当前数字
        public void addNum(int num) {
            if(min.size()==max.size()){
                max.offer(num);
                min.offer(max.poll());
            }
            else{
                min.offer(num);
                max.offer(min.poll());
            }
        }

        //查找当前中位数
        public double findMedian() {
            //如果数据流中没有数字，则返回-1
            if(min.size()==0&&max.size()==0) return -1.0;
            if(min.size()==max.size()){
                return (min.peek()+max.peek())/2.0;
            }
            else{
                return min.peek();
            }
        }
    }
}
