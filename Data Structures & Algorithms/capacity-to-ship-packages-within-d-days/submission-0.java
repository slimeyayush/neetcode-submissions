class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for(int w:weights) {
            l = Math.max(w,l);
            r += w;
        }
        while(l < r) {
            int m = l + (r-l)/2;
            if(check(weights,days,m)) {
                r = m; // looking for better answer without discarding a valid one (might be the best)
            }
            else {
                l = m+1;
            }
        }
        return l;
    }
    public boolean check(int[] weights,int days,int w) {
        int day = 1;
        int curr = 0;
        for(int we:weights) {
            if(curr + we <= w) {
                curr += we;
            }
            else {
                day++;
                curr = we;
            }
        }
        return day <= days;
    }

}