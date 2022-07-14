class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        char [] x = text1.toCharArray();
        char [] y = text2.toCharArray();
        
        int m = x.length;
        int n = y.length;
        
        int [][] dp = new int [m+1][n+1];
         for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++)
                dp[i][j] = -1;
            }
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }  if (dp[i][j] != -1) {
                    return dp[i][j];
                }else if(x[i-1] == y[j-1] ){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                     dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        
        return dp[m][n];
    }
    
    
    public int max(int i ,int j){
        return i > j ? i :j;
    
    }
}