class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack(0, 0);
        return ans;
    }

    public void backtrack(int open, int closed) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        // Add '(' if we still have some left
        if (open < n) {
            sb.append('(');
            backtrack(open + 1, closed);
            sb.deleteCharAt(sb.length() - 1);
        }

        // Add ')' only if it won't make the string invalid
        if (closed < open) {
            sb.append(')');
            backtrack(open, closed + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}