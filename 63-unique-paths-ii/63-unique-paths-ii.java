class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return dp(m-1,n-1,memo,obstacleGrid);
    }
    
    
    public int dp(int m,int n,int[][] memo,int[][] obstacleGrid){
        if(m >= 0 && n>=0 && obstacleGrid[m][n] == 1 ) return 0;
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(memo[m][n]!=-1)
            return memo[m][n];
        int l = dp(m-1,n,memo,obstacleGrid);
        int r = dp(m,n-1,memo,obstacleGrid);
        memo[m][n] = l+r;
        return memo[m][n];
    }
    
}