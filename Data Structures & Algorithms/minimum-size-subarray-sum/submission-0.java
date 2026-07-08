class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int curSum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            curSum += nums[i];
            int r = nums[i];
            map.put(r,map.getOrDefault(r,0) + 1);
            while(curSum >= target) {
                minLen = Math.min(minLen,i - left + 1);
                curSum -= nums[left];
                left++; 
            }
        }
        return minLen == Integer.MAX_VALUE?0:minLen;
    }
}