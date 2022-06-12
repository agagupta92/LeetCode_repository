class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return func(0,n,arr,k,dp);
    }
    
    public int func(int ind,int n,int arr[],int k,int [] dp){
        if(ind == n) return 0;
        if(dp[ind] != -1) return dp[ind];
        int maxiSum =Integer.MIN_VALUE;
        int len =0;
        int maxi = Integer.MIN_VALUE;
        for(int j=ind;j<Math.min(ind+k,n);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            int sum = (len*maxi) + func(j+1,n,arr,k,dp);
            maxiSum=Math.max(sum,maxiSum);
            
        }
        return dp[ind] = maxiSum;
    }
}