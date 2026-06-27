class Solution {
   public void sortColors(int[] nums) {
        int l = 0;                 // next position for 0
        int m = 0;                 // current index
        int r = nums.length - 1;   // next position for 2

        while (m <= r) {
            if (nums[m] == 1) {
                m++;
            } 
            else if (nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } 
            else { // nums[m] == 2
                swap(nums, m, r);
                r--;
                // NOTE: do NOT increment m here
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}