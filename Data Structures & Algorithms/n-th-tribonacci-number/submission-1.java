class Solution {
    Integer[] memo;
    public int tribonacci(int n) {
        memo = new Integer[n];
        return solve(n);
    }
    public int solve(int n) {
        if(n<=0) {
            return 0;
        }
        if(n<=2) {
            return 1;
        }
        if (memo[n-1] != null) {
    return memo[n-1];
}

        int curr =  solve(n-1) + solve(n-2) + solve(n-3);
        memo[n-1] = curr;
        return curr;
    }
}