class Solution {
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i =0;i<n;i++)
            for(int j =0;j<n+1;j++)
                dp[i][j] = -1;
        
        return recu(0,-1,nums,n,dp);
    }
    
    public int recu(int ind,int prev , int [] nums,int n,int[][] dp){
        if(ind == n) return 0;
            
        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];
        
        int len = 0 + recu(ind+1,prev,nums,n,dp);
        if(prev == -1 || nums[ind] > nums[prev]){
        
          len = Math.max(len,1 + recu(ind+1,ind,nums,n,dp));
        }
        return dp[ind][prev+1] = len;
    }
}