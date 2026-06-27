class Solution {
     private static final int[][] DIRS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                   if(backtrack(board,i,j,word,0)) {
                    return true;
                   }

                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board,int i , int j , String word,int index) {
        if(index == word.length()) {
            return true;
        }
        if( i < 0 || j < 0 || i >= board.length || j>= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';

         for (int[] d : DIRS) {
            if (backtrack(board, i + d[0], j + d[1], word, index + 1)) {
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}
