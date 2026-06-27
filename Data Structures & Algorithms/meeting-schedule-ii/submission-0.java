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
    public int minMeetingRooms(List<Interval> intervals) {
          
          
          int n = 0;
          for(Interval x : intervals) {
                 n = Math.max(n,x.end);
          }
          int[] sweep = new int[n+1];
          for(Interval x:intervals) {
             sweep[x.start]++;
             if(x.end < sweep.length)
    sweep[x.end]--;
          }
          int ans = 0;
          for(int i=1; i<=n; i++) {
            sweep[i] += sweep[i-1];
            ans = Math.max(sweep[i],ans);
          }
          return ans;
    }
}
