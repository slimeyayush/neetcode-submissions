class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        backtrack(nums,0,used,new ArrayList<>(),res);
        return res;
    }
    public void backtrack(int[] nums,int index,boolean[] used,List<Integer> curr,List<List<Integer>> res) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(used[i]) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums,0,used,curr,res);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}