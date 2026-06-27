class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        int i = 0;
        while( i < t.length() && j < s.length()) {
             if(s.charAt(j) == t.charAt(i)) {
                i++;
                j++;
             }
             else {
                i++;
             }
        }
        if(j >= s.length()) {
            return true;
        }
        else {
            return false;
        }
    }
}