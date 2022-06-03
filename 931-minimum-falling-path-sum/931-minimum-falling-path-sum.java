class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);
         int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < m; i++)
            result = Math.min(result, solve(n - 1, i,n,m, matrix,dp));
        
        return result;
    }
    
    int solve(int i ,int j,int n ,int m ,int [][] a,int[][] dp){
        if(j <0 || j >=m) return Integer.MAX_VALUE;
        if(i==0) return a[0][j];
        if(dp[i][j] != -1) return dp[i][j];
        int s = solve(i-1,j,n,m,a,dp);
        int s1 =  solve(i-1,j-1,n,m,a,dp);
        int s2 =  solve(i-1,j+1,n,m,a,dp);
        return dp[i][j] = Math.min(s,Math.min(s1,s2)) + a[i][j];
    }
}



/*public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++)
            result = Math.min(result, solve(m - 1, i, matrix, dp));
        
        return result;
    }
    
    private int solve(int m, int n, int[][] matrix, int[][] dp){
        
        if(n < 0 || n >= matrix[m].length) return Integer.MAX_VALUE;
        
        if(m == 0) return matrix[0][n];
    
        int up = solve(m - 1, n, matrix, dp);
        int left = solve(m - 1, n - 1, matrix, dp);
        int right = solve(m - 1, n + 1, matrix, dp);
        
        return Math.min(Math.min(left, right), up) + matrix[m][n];
        
    }   */
