class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : nums) {
            // start only if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int curr = num;
                int currLength = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    currLength++;
                }

                maxLen = Math.max(maxLen, currLength);
            }
        }
        return maxLen;
    }
}
