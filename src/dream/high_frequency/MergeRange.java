package dream.high_frequency;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/24 0:13
 * author: Garden Chan
 * description: NC37 合并区间
 */
public class MergeRange {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        ArrayList<Interval> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            int L = intervals.get(i).start;
            int R = intervals.get(i).end;
            if (ans.size()==0 || ans.get(ans.size()-1).end<L){
                ans.add(new Interval(L, R));
            }else {
                ans.get(ans.size() - 1).end = Math.max(ans.get(ans.size() - 1).end, R);
            }
        }
        return ans;
    }
}
