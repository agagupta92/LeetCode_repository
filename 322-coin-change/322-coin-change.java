class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length-1;
        int dp[][] = new int[n+1][amount+1];
        for(int i =0;i<n+1;i++)
            for(int j =0;j < amount+1;j++)
                dp[i][j] = -1;
        int ans =  recu(n,coins,amount,dp);
        if(ans >= 1e9) return -1;
        return ans;
        
    }
    
    public int recu(int ind,int [] coins,int amount,int[][] dp){
        if(ind == 0){
            if(amount % coins[0] == 0){
                return amount/coins[0];
            } else
                return (int)1e9;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int nottake = 0 + recu(ind-1,coins,amount,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= amount)
        take = 1 + recu(ind,coins,amount-coins[ind],dp);
        return dp[ind][amount] = Math.min(take,nottake);
    }
}