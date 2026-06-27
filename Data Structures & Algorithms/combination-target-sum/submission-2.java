class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums,0,target,new ArrayList<>(), ans);
        return ans;
    }
    public void backtrack(int[] nums,int index,int target,List<Integer> curr,List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums,i,target-nums[i],curr,ans);
            curr.remove(curr.size() -1);
        }
    }
}
