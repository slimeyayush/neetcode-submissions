class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,res,new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums,int index,List<List<Integer>> res,List<Integer> curr) {
        res.add(new ArrayList<>(curr));

        for(int i=index;i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums,i+1,res,curr);
            curr.remove(curr.size() - 1);
        }
    }
}
