class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for(int p :piles) {
            r = Math.max(r,p);
        }
        while(l < r) {
            int m = l + (r-l)/2;
            if(check(piles,h,m)) {
                r = m;
            }
            else {
                l = m+1;
            }
        }
        return r;
    }
    public boolean check(int[] piles,int h,int speed) {
        long time = 0;
        for(int pile:piles) {
            if(pile%speed == 0) {
                time += (pile)/speed;
            }
            else {
                time += (pile)/speed + 1;
            }
        }
        return time <= h;
    }
}
