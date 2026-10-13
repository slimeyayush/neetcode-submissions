class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String temp = strs[0];
        for(int i=1; i<n; i++) {
           StringBuilder sb = new StringBuilder();
           int j=0; 
           String curr = strs[i];
           while(j < temp.length() && j < curr.length()) {
              if(temp.charAt(j) == curr.charAt(j)) {
                sb.append(temp.charAt(j));
              }
              else {
                break;
              }
              j++;
           }
           temp = sb.toString();
           
        }
        return temp;
    }
}