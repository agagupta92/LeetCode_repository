class Solution {
    public int maxCoins(int[] cost) {
        
        int[] nums = new int[cost.length + 2];
        int n = 1;
        for (int x : cost) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
}

public int burst(int[][] memo, int[] nums, int left, int right) {
    if (left + 1 == right) return 0;
    if (memo[left][right] > 0) return memo[left][right];
    int ans = 0;
    for (int i = left + 1; i < right; ++i)
        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
        + burst(memo, nums, left, i) + burst(memo, nums, i, right));
    memo[left][right] = ans;
    return ans;
}
    /*
        int n = nums.length;
        int [] temp = new int[nums.length+2];
        temp[0] = 0;
        int m =1;
        for(int i =0;i<nums.length;i++){
            temp[m]=nums[i];
            m++;
        }
        temp[m]=1;
        System.out.println(temp.length);
        
        System.out.println(n);
        int[][] dp = new int[n+1][n+1];
        for(int []d:dp){
            Arrays.fill(d,-1);
        }
        return func(1,n,temp,dp);
    }
    
    public int func(int i ,int j ,int[] nums,int[][] dp){
        if(i>j) return 0;
         if(dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = (nums[i-1]*nums[ind]*nums[j+1])+func(i,ind-1,nums,dp) +func(ind+1,j,nums,dp);
            maxi = Math.max(maxi,cost);
        }
        return dp[i][j] = maxi;
    }*/
}