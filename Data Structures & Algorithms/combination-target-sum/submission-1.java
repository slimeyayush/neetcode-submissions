class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),target,res);
        return res;
    }
    public void backtrack(int[] nums,int index,List<Integer> curr,int target,List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums,i,curr,target-nums[i],res);
            curr.remove(curr.size() - 1);
        }
    }
}
