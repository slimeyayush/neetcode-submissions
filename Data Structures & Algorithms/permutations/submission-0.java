class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),used,res);
        return res;
    }
    public void backtrack(int[] nums,List<Integer> curr,boolean[] used,List<List<Integer>> res) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums,curr,used,res);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
