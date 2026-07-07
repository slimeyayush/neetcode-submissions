class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int x:piles) {
            r = Math.max(x,r);
        }
        int ans = 0;
        while(l <= r) {
            int m = l + (r-l)/2;

            if(check(piles,h,m)) {
                 ans = m;
                 r = m-1;
            } 
            else {
                l = m+1;
            }
        }
        return ans;
    }
    public boolean check(int[] piles,int h,int m) {
        int n = piles.length;
        long total = 0;
        for(int i=0; i<n; i++) {
            total += (piles[i] + m - 1)/m;
        }
        if(total <= h) {
            return true;
        }
        else {
            return false;
        }
    }
}
