class Solution {
    public int removeDuplicates(int[] nums) {
        int lastWrite = nums[0];
        int writeIdx = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != lastWrite) {
                nums[writeIdx] = nums[i];
                writeIdx++;
                lastWrite = nums[i];
            }
        }
        return writeIdx;
    }
}