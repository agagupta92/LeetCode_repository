class Solution {
    public int longestPalindromeSubseq(String s) {
         StringBuilder input1 = new StringBuilder(s);
            input1.reverse();
        System.out.print(input1.toString());
        String t = input1.toString();
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for(int i =0;i<n;i++)
            for(int j =0;j < m;j++)
                dp[i][j] = -1;
        return lcs(n-1,m-1,s,t,dp);
    }
    
    public int lcs(int n,int m,String s,String t,int dp[][]){
        if(n < 0 || m <0){
            return 0;
        }
        if(dp[n][m] != -1) return dp[n][m];
        if(s.charAt(n)==t.charAt(m))
            return 1 + lcs(n-1,m-1,s,t,dp);
        
        return dp[n][m] = Math.max(lcs(n,m-1,s,t,dp),lcs(n-1,m,s,t,dp));
        
    }
}
    /*public int lcs(String s,String t){
        int n = s.length();
        int m = t.length();
        int [] prev = new int[m+1];
        int [] cur = new int[m+1];
        
        
        for(int i =0;i<=m;i++) prev[i]=0;
        
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                }else {
                    cur[j] = Math.max(prev[j],cur[j-1]);
                }
            
            }
            prev = cur;
        }
        return prev[m];
        
    }*/
