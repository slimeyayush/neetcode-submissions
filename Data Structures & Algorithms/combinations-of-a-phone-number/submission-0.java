class Solution {
    private static final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        backtrack(digits,0,res,sb);
        return res;
    }
    public void backtrack(String digits,int index,List<String> res,StringBuilder sb) {
        
        if(sb.toString().length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digitNum = digits.charAt(index) - '0';
    String letters = MAPPING[digitNum];
        for (int j = 0; j < letters.length(); j++) {
        sb.append(letters.charAt(j));      // Choose
        backtrack(digits, index + 1, res, sb); // Explore next digit
        sb.deleteCharAt(sb.length() - 1);  // Backtrack (Un-choose)
    }
    }
}
