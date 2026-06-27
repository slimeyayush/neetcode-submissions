class Solution {
    Integer[] memo;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int n = nums.length;

        // CASE 1: Rob Houses 0 to n-2 (Exclude Last)
        // We reset memo for this specific problem
        memo = new Integer[n]; 
        // We pass 'n-1' because we want the recursion to stop at index n-2
        int max1 = solve(nums, 0, n - 1); 

        // CASE 2: Rob Houses 1 to n-1 (Exclude First)
        // We reset memo AGAIN for the second problem. 
        // DO NOT SHARE MEMO.
        memo = new Integer[n]; 
        int max2 = solve(nums, 1, n);

        return Math.max(max1, max2);
        
    }
    public int solve(int[] nums,int min,int n) {
        if (n <= min) {
            return 0;
        }

        if(memo[n-1] != null) {
            return memo[n-1];
        }
        int skip = solve(nums,min,n-1);
        int take = nums[n-1] + solve(nums,min,n-2);

        memo[n-1] = Math.max(skip,take);
        return Math.max(skip,take);
    }
}
