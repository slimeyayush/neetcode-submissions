class Solution {
    public int findMin(int[] nums) {
        // 3 4 5 6 1 2 -> h1 h2
        // mid lands on h1 5 > 2 l = mid + 1 // first half me min can't lie if not r = m; m can be the potential answer
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int m = (l) + (r-l)/2;
            if(nums[m] < nums[r]) {
                r = m;
            }
            else {
                l = m+1;
            }
        }
        return nums[l];
    }
}
