class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int maxGain = 0;
        int grumpLost = 0;
        int total = 0;
        for(int i=0; i<minutes; i++) {
           grumpLost += (grumpy[i] == 1)? customers[i]:0;
           total += (grumpy[i] == 0)?customers[i]:0;
        }
        maxGain = Math.max(maxGain,grumpLost);
        for(int i=minutes; i<n; i++) {
           grumpLost -= (grumpy[i-minutes] == 1)?customers[i-minutes]:0;
           grumpLost += (grumpy[i] == 1)?customers[i]:0;
           total += (grumpy[i] == 0)?customers[i]:0;

           maxGain = Math.max(maxGain,grumpLost);

        }
        return maxGain + total;
    }
}