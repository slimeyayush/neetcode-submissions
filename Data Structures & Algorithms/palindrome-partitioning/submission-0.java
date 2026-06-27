class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> curr = new ArrayList<>();
    String s;
    int n;

    public List<List<String>> partition(String s) {
        this.s = s;
        this.n = s.length();

        backtrack(0);
        return ans;
    }

    public void backtrack(int start) {
        if (start == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int end = start; end < n; end++) {
            if (isPal(start, end)) {
                curr.add(s.substring(start, end + 1));

                backtrack(end + 1);

                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPal(int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}