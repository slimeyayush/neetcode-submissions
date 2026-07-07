class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        int tempMax = height[0];
        for(int i=1; i<n; i++) {
            maxL[i] = tempMax;
            tempMax = Math.max(tempMax,height[i]);
        }
        tempMax = height[n-1];
        for(int i=n-2; i>=0; i--) {
            maxR[i] = tempMax;
            tempMax = Math.max(tempMax,height[i]);
        }
        int total = 0;
        // water for each ver sec = min(rightmax,leftmax) - height[0];
        for(int i=0; i<n; i++) {
           int water = Math.min(maxL[i],maxR[i]) - height[i];
           total += (water > 0)? water:0;

        }
        return total;
    }
}
