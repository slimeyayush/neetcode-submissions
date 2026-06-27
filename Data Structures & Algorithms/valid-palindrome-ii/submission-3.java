class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l<=r) {
          if(s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
          }
          else {
            return isPali(s,l+1,r) || isPali(s,l,r-1);
          }
        }
        return true; 
    }
    public boolean isPali(String s,int left,int right) {
      while(left <= right) {
        if(s.charAt(left) != s.charAt(right)) {
          return false;
        }
        left++;
        right--;
      }
      return true;
    }
}