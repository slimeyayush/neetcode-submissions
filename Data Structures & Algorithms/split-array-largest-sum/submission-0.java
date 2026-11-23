class Solution {
    public int splitArray(int[] nums, int k) {
        // atleast one subarray will have the max element 
        int l =0;
        int r = 0;
        for(int num:nums) {
            l = Math.max(l,num);
            r += num; // 1 subarray case;
        }
        while(l < r) {
            int m = l + (r-l)/2;
            if(check(nums,k,m)) {
                r = m;
            }
            else {
                l = m+1;
            }
        }
        return l;

    }
    public boolean check(int[] nums,int k,int sum) {
        int cut = 1;
        int curr = 0;
        for(int num:nums) {
            if(curr + num <= sum) {
                curr += num;
            }
            else {
                cut++;
                curr = num;
            }
        }
        return cut <=k;
    }
}