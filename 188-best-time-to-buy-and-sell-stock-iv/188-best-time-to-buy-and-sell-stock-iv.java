class Solution {
    public int maxProfit(int k, int[] price) {
     int n  = price.length;
        
        int dp[][][] = new int[n+1][2][k+1];
        for(int i =0;i<n;i++)
            for(int j =0;j <2;j++)
                for(int l =0;l <k;l++)
                dp[i][j][l] = 0;
        
        
        for(int ind = n-1;ind >=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy == 1 ){
                        dp[ind][buy][cap] = Math.max(-price[ind] + dp[ind+1][0][cap],0+                                            dp[ind+1][1][cap]);
                    } else {
                        dp[ind][buy][cap] = Math.max(price[ind] + dp[ind+1][1][cap -1],0+                                          dp[ind+1][0][cap]);
                    }
                 }
            }
        }
        return dp[0][1][k];
    }
    
}