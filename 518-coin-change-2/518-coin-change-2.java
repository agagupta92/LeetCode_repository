

class Solution {
   public int change(int amount, int[] coins) {
      int n = coins.length-1;
        int dp[][] = new int[n+1][amount+1];
        for(int i =0;i<n+1;i++)
            for(int j =0;j < amount+1;j++)
                dp[i][j] = -1;
        int ans =  recu(n,coins,amount,dp);
        
        return ans;
        
    }
    
    public int recu(int ind,int [] coins,int amount,int[][] dp){
        if(ind == 0){
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int nottake = recu(ind-1,coins,amount,dp);
        int take = 0;
        if(coins[ind] <= amount)
        take = recu(ind,coins,amount-coins[ind],dp);
        return dp[ind][amount] = take+nottake;
    }
}