/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    // method 1
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        ArrayList<Interval> result = new ArrayList<>();
        
        if(intervals.size() == 0)
            return result;
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start <= end) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        
        result.add(new Interval(start, end));
        return result;
    }
       
     // method 2
     public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            Interval t = intervals.get(i);
            start[i] = t.start;
            end[i] = t.end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        int j = 0;
        List<Interval> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i == n-1 || start[i+1] > end[i]) {
                res.add(new Interval(start[j], end[i]));
                j = i + 1;
            }
        }
        return res;
    }
}
