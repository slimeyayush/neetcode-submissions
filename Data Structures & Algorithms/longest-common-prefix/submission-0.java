class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for(String str: strs) {
            minLen = Math.min(minLen,str.length());
        }
        int low = 1;
        int high = minLen;
        int ansLength = 0;
        while(low <= high) {
          int mid = (low+high)/2;
          if(isPrefix(strs,mid)) {
            ansLength = mid;
            low = mid+1;
          }
          else {
            high = mid-1;
          }
        }
        return strs[0].substring(0,ansLength);
    }
    public boolean isPrefix(String[] strs,int length) {
        String str = strs[0].substring(0,length);
        for(int i=1; i<strs.length; i++) {
            if(!strs[i].startsWith(str)) {
                return false;
            } 
        }
        return true;
    }
}