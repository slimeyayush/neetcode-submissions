/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
       
       int n = intervals.size();
       if(n==0) {
        return true;
       }
       Collections.sort(intervals,(a,b) -> {
          int comp = a.end - b.end;
          if(comp == 0) {
            return a.start - b.start;
          }
          return comp;
       });
       int lastEnd = intervals.get(0).end;
       for(int i=1; i<n; i++) {
           if(intervals.get(i).start < lastEnd) {
                return false;
           }
           lastEnd = intervals.get(i).end;
       }
       return true;
    }
}
