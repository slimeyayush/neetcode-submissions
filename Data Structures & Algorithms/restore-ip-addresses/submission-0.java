class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(0, 0, s, new StringBuilder(), ans);
        return ans;
    }

    public void backtrack(int start, int parts, String s,
                          StringBuilder sb, List<String> ans) {

        if (parts == 4) {
            if (start == s.length()) {
                ans.add(sb.substring(0, sb.length() - 1)); // remove last '.'
            }
            return;
        }

        for (int end = start; end < Math.min(s.length(), start + 3); end++) {
            String part = s.substring(start, end + 1);

            if (isValid(part)) {
                int len = sb.length();

                sb.append(part);
                sb.append('.');

                backtrack(end + 1, parts + 1, s, sb, ans);

                sb.setLength(len);
            }
        }
    }

    public boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }

        int val = Integer.parseInt(part);
        return val >= 0 && val <= 255;
    }
}