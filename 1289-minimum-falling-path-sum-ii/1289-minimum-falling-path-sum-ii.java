class Solution {
    public int minFallingPathSum(int[][] grid) {
         int[][] dp = new int[grid.length+1][grid.length+1];
        for(int i=0;i<=grid.length;i++) {
            for(int j=0;j<=grid.length;j++) {
                dp[i][j] = -1;
            }
        }
        return solve(grid, grid.length-1, grid.length, dp);
    }
    private int solve(int[][] grid, int ind, int last, int[][] dp) {
        if(ind<0){
            return 0;
        }
        if(dp[ind][last]!=-1) {
            return dp[ind][last];
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++) {
            if(i!=last) {
                int point = grid[ind][i] + solve(grid, ind-1, i, dp);
                mini = Math.min(mini, point);
            }
        }
        return dp[ind][last] = mini;
    }
}