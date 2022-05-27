class Solution {
    public int numDistinct(String s, String t) {
      int n  = s.length();
        int m = t.length();
        
        int dp[][] = new int[n+1][m+1];
        for(int i =0;i<n+1;i++)
            for(int j =0;j <m+1;j++)
                dp[i][j] = -1;
        
        return recu(n-1,m-1,s,t,dp);
    }
    
    //
    public int recu(int i ,int j, String s1, String s2,int dp[][]){
        if(j <0) return 1;
        if(i <0)return 0;
         if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = (recu(i-1,j-1,s1,s2,dp) + recu(i-1,j,s1,s2,dp));
        else 
            return dp[i][j] = recu(i-1,j,s1,s2,dp);
        
    }
}