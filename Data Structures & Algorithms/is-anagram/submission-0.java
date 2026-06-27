class Solution {
    public boolean isAnagram(String s, String t) {
            int m = s.length();
            int n = t.length();
            if( m!=n) {
                return false;
            }
            return anaCheck(s,t);
        
    }
    public boolean anaCheck(String s,String t) {
        int[] freq = new int[26];
        for(char x: s.toCharArray()) {
            freq[x - 'a']++;
        }
        for(char x: t.toCharArray()) {
            freq[x - 'a']--;
        }
        for(int x : freq) {
            if(x > 0) {
                return false;
            }
        }
        return true;
    }
}
