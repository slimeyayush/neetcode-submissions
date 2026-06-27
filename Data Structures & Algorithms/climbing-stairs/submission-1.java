class Solution {
    Integer[] memo;
    public int climbStairs(int n) {
        memo = new Integer[n+1];
        return solve(n);
    }
    public int solve(int n) {
        if(n==0) {
            return 1;
        }
        if(n<0) {
            return 0;
        }
        if(memo[n] != null) {
            return memo[n];
        }
        int ways = solve(n-1) + solve(n-2);

        memo[n] = ways;
        return ways;
    }
}
