class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int i=0; i<n; i++) {
            char r = s.charAt(i);
            map.put(r,map.getOrDefault(r,0) + 1);
            if(map.get(r) > 1) {
                while(map.get(r) > 1) {
                    char l = s.charAt(left);
                    map.put(l,map.get(l) - 1);
                    left++;
                }
            }
            maxLen = Math.max(maxLen,i - left + 1);
        }
        return maxLen;
    }
}
