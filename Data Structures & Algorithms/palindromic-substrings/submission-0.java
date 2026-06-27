class Solution {
    Boolean[][] memo;
    int count = 0;
    public int countSubstrings(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isPalindrome(s,i,j)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isPalindrome(String s, int i, int j) {
        // 1. BASE CASES
        if (i >= j) return true; // Single char or empty middle (e.g. "aa")

        // 2. MEMO CHECK
        if (memo[i][j] != null) return memo[i][j];

        // 3. RECURRENCE
        if (s.charAt(i) == s.charAt(j)) {
            // If match, result depends on the inner part
            memo[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            // If mismatch, definitely not a palindrome
            memo[i][j] = false;
        }

        return memo[i][j];
    }
}
