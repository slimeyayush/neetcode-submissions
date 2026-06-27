class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        while(l < r) {
           int width = r - l;
           int area = 0;
           if(heights[l] <= heights[r]) {
                area = heights[l]*width;
                l++;
           }
           else {
            area = heights[r]*width;
            r--;
           }
           maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
