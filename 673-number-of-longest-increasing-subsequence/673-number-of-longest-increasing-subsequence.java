class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        for(int i =0;i<n;i++){
            dp[i] = 1;
            cnt[i] =1;
        }
        int maxi = 1;
        for(int i =0;i <n;i++){
            for(int prev =0 ;prev<i;prev++){
                if(nums[prev]<nums[i] && 1 + dp[prev]>dp[i]){
                    dp[i] = 1+dp[prev];
                    cnt[i]=cnt[prev];
                } else if(nums[prev]<nums[i] && 1 + dp[prev] == dp[i]){
                     cnt[i] +=cnt[prev];
                }
                if(dp[i]>maxi){
                    maxi = dp[i];
                }
            }
        }
        
        int nos =0;
        for(int i =0;i <n ;i++){
            if(dp[i] == maxi) nos+=cnt[i];
        }
        
        return nos;
    }
}