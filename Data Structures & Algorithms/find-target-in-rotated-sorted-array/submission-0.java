class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int p = findMin(nums);
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int m = l + (r-l)/2;
            int org = (m+p)%n;
            if(nums[org] == target) {
                return org;
            }
            else if(nums[org] < target) {
                l = m + 1;
            }
            else {
                r=m-1;
            }
        }
        return -1;
    }
     public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int t = nums[r];
        // two sections every val in first sec greater than second 
        while(l < r) {
            int m = l + (r-l)/2;
            if(nums[m] > nums[r]) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return l;
    }
}
