class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> check = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            if(check.contains(nums[i])) {
                return true;
            }
            check.add(nums[i]);
        }
        return false;
    }
}