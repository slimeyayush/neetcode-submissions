class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 3 section before new -> overlapping -> after new
        int i =0;
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        while(i < n && newInterval[0] > intervals[i][1]) {
            ans.add(intervals[i++]);
        }
        while(i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i<n && intervals[i][0] > newInterval[1]) {
            ans.add(intervals[i++]);
        }
        int size = ans.size();
        int[][] res = new int[size][2];
        for(int j=0; j<size; j++) {
           res[j] = ans.get(j);
        }
        return res;
        
    }
}
