class Solution {
    Integer[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new Integer[cost.length + 1];
        return solve(cost,cost.length);
    }
    public int solve(int[] cost,int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        
        if(memo[n] != null) {
            return memo[n];
        }
        int cameFromLastStep = cost[n-1] + solve(cost,n-1);
        int cameFromSecondLast = cost[n-2] + solve(cost,n-2);

        int minCost = Math.min(cameFromLastStep,cameFromSecondLast); 
        

        memo[n] = minCost;
        return minCost;
    }

}
