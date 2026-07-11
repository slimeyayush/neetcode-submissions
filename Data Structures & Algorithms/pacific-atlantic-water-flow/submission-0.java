class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacVis = new boolean[m][n];
boolean[][] atlVis = new boolean[m][n];
        for(int i=0; i<m; i++) {
            dfs(heights,pacific,pacVis,i,0);
        }

        for(int i=0; i<n; i++) {
            dfs(heights,pacific,pacVis,0,i);
        }

        for(int i=0; i<m; i++) {
            dfs(heights,atlantic,atlVis,i,n-1);
        }
        for(int i = 0; i<n; i++) {
            dfs(heights,atlantic,atlVis,m-1,i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> co = new ArrayList<>();
                    co.add(i);
                    co.add(j);
                    ans.add(co);
                }
            }
        }

        return ans;
    }
    public void dfs(int[][] heights,boolean[][] ocean,boolean[][] vis,int r ,int c) {
          if(vis[r][c]) {
    return;
}
          int m = heights.length;
          int n = heights[0].length;
          int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

          vis[r][c]  = true;
          ocean[r][c] = true;

          for(int[] d : dir) {
            int nr = d[0] + r;
            int nc = d[1] + c;
            if(nr < 0 || nr >=m || nc < 0 || nc >= n) {
                continue;
            }
            if(vis[nr][nc] == true) {
                continue;
            }
            
            if(heights[nr][nc] < heights[r][c]) {
                continue;
            }
             dfs(heights, ocean, vis, nr, nc);
          }
    }
}
