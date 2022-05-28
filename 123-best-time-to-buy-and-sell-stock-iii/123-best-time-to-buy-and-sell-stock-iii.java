class Solution {
    public int maxProfit(int[] price) {
    int n  = price.length;
        
        int dp[][][] = new int[n+1][2][3];
        for(int i =0;i<n;i++)
            for(int j =0;j <2;j++)
                for(int k =0;k <3;k++)
                dp[i][j][k] = 0;
        
        
        for(int ind = n-1;ind >=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy == 1 ){
                        dp[ind][buy][cap] = Math.max(-price[ind] + dp[ind+1][0][cap],0+                                            dp[ind+1][1][cap]);
                    } else {
                        dp[ind][buy][cap] = Math.max(price[ind] + dp[ind+1][1][cap -1],0+                                          dp[ind+1][0][cap]);
                    }
                 }
            }
        }
        
        
        return dp[0][1][2];
    }
    
    public int recu(int ind ,int buy,int cap,int[] price,int n,int dp[][][]){
        if(ind == n || cap ==0) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        int profit = 0;
        if(buy == 1 ){
            profit = Math.max(-price[ind] + recu(ind+1,0,cap,price,n,dp),0+ recu(ind+1,1,cap,price,n,dp));
        } else {
            profit = Math.max(price[ind] + recu(ind+1,1,cap -1,price,n,dp),0+ recu(ind+1,0,cap,price,n,dp));
        }
       // if(dp[i][j] != -1) return dp[i][j];
        return dp[ind][buy][cap] = profit;
    
    }
}