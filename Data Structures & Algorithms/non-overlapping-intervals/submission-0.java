class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int lastEnd = Integer.MIN_VALUE;
        int valid = 0;
        Arrays.sort(intervals,(a,b) -> {
            int comp = Integer.compare(a[1],b[1]);
            if(comp == 0) {
                return Integer.compare(a[0],b[0]);
            }
            return comp;
        });
        for(int i=0; i<n; i++) {
            if(intervals[i][0] >= lastEnd) {
                valid++;
                lastEnd = intervals[i][1];
            }
        }
        return n-valid;
    }
}
