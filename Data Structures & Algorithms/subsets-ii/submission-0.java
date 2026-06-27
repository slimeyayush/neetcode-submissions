class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>(),res);
        return res;
    }
    public void backtrack(int[] nums, int index,List<Integer> curr,List<List<Integer>> res ) {
        res.add(new ArrayList<>(curr));

        for(int i = index; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && i > index) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums,i+1,curr,res);
            curr.remove(curr.size() - 1);
        }
    }
}
