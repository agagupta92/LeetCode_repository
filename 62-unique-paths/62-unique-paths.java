class Solution {
   
    
    public int dp(int m,int n,int[][] memo){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(memo[m][n]!=-1)
            return memo[m][n];
        int l = dp(m-1,n,memo);
        int r = dp(m,n-1,memo);
        memo[m][n] = l+r;
        return memo[m][n];
    }
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return dp(m-1,n-1,memo);
    }
}