class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int currCount = 0;
        for(int x:nums) {
            if(x == 0) {
                
                currCount = 0;
            }
            else {
                currCount++;
            }
            maxOnes = Math.max(currCount,maxOnes);
        }
        return maxOnes;
    }
}