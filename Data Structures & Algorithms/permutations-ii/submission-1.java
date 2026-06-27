class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    boolean[] used;
    int[] nums;
    int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        this.nums = nums;
        this.n = nums.length;
        this.used = new boolean[n];

        backtrack();
        return ans;
    }

    public void backtrack() {
        if (curr.size() == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            curr.add(nums[i]);

            backtrack();

            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}