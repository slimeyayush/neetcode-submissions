class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,new ArrayList<>(),target,res);
        return res;
    }
    public void backtrack(int[] nums,int index,List<Integer> curr,int target,List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target<0) {
            return;
        }
        for(int i=index; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && i > index) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums,i+1,curr,target-nums[i],res);
            curr.remove(curr.size() -1);
        }
    }
}
