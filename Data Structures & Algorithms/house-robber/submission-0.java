class Solution {
    Integer[] memo;
    public int rob(int[] nums) {
        memo = new Integer[nums.length];
        return solve(nums,nums.length);
        
    }
    public int solve(int[] nums,int n) {
        if(n <=0) {
            return 0;
        }

        if(memo[n-1] != null) {
            return memo[n-1];
        }
        int skip = solve(nums,n-1);
        int take = nums[n-1] + solve(nums,n-2);

        memo[n-1] = Math.max(skip,take);
        return Math.max(skip,take);
    }
}
