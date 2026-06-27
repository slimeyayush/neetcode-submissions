class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,res,new ArrayList<>(),0,target);
        return res;
    }
    public void backtrack(int index,int[] nums,List<List<Integer>> res,ArrayList<Integer> curr , int sum ,int target) {
        if(sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(sum > target) return;
        for(int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i,nums,res,curr,sum + nums[i],target);
            curr.remove(curr.size() - 1);
        }
    }
}