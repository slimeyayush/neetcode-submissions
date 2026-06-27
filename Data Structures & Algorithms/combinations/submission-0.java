class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        
        int nums[] = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = i+1;
        }
        backtrack(nums,0,new ArrayList<>(),n,k);
        return res;
        
    }
    public void backtrack(int[] nums,int index,List<Integer> curr,int n,int k) {
        if(curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums,i+1,curr,n,k);
            curr.remove(curr.size() -1);
        }
    }
}