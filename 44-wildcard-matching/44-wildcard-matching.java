class Solution {
    public boolean isMatch(String s, String p) {
      int n = p.length();
      int m  = s.length();
       
        
        int dp[][] = new int[n][m];
        for (int row[]: dp)
            Arrays.fill(row, -1);
        
        return recu(n-1,m-1,p,s,dp) == 1 ? true : false;
    }
    
    public int recu(int i ,int j, String p, String s,int dp[][]){
        if(j <0 && i <0) return 1;
        if(j >=0 && i <0) return 0;
        if(j <0 && i >=0) {
            for(int ii=0;ii<=i;ii++){
                if(p.charAt(ii) != '*') return 0;
            }
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        
        if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?')
            return dp[i][j] = recu(i-1,j-1,p,s,dp);
        else{
            if( p.charAt(i) == '*')
                return dp[i][j] = (recu(i-1,j,p,s,dp) == 1 || recu(i,j-1,p,s,dp) ==1)?1:0;
            else
            return dp[i][j]=0;
        }
    }
}

/*//Base Conditions
    if (i < 0 && j < 0)
      return 1;
    if (i < 0 && j >= 0)
      return 0;
    if (j < 0 && i >= 0)
      return isAllStars(S1, i) ? 1 : 0;

    if (dp[i][j] != -1) return dp[i][j];

    if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
      return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);

    else {
      if (S1.charAt(i) == '*')
        return (wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1 || wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
      else return 0;
    }
  }*/