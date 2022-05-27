class Solution {
    public String shortestCommonSupersequence(String s, String t) {
        
        int n = s.length();
        int m = t.length();
         int dp[][] = new int[n+1][m+1];
        for(int i =0;i<=n;i++) dp[i][0]=0;
        for(int j =0;j<=m;j++) dp[0][j]=0;
        
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i =n,j =m;
        while(i >0 && j >0){
            if(s.charAt(i-1) == t.charAt(j-1)){
                ans.append(s.charAt(i-1));
                i--;j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                ans.append(s.charAt(i-1));
                i--;
            } else {
                ans.append(t.charAt(j-1));
                j--;
            }
        }
        
        while(i >0){
             ans.append(s.charAt(i-1));
            i--;
        }
        while(j >0){
             ans.append(t.charAt(j-1));
            j--;
        }
        
        return ans.reverse().toString();
    }
    
    /*public int lcs(String s,String t){
        int n = s.length();
        int m = t.length();
         int dp[][] = new int[n+1][m+1];
    
        
        
        for(int i =0;i<=n;i++) dp[i][0]=0;
        for(int j =0;j<=m;j++) dp[0][j]=0;
        
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
        
    }*/
}