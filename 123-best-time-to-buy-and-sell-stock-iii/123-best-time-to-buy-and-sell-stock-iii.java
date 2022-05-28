class Solution {
    public int maxProfit(int[] prices) {
    int n  = prices.length;
        
        int dp[][][] = new int[n][2][3];
        for(int i =0;i<n;i++)
            for(int j =0;j <2;j++)
                for(int k =0;k <3;k++)
                dp[i][j][k] = -1;
        
        
        return recu(0,1,2,prices,n,dp);
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