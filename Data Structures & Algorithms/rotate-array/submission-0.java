class Solution {
    public void rotate(int[] nums, int k) {
        int[] copy = nums.clone();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            nums[(i+k)%n] = copy[i];
        }
       
    }
}