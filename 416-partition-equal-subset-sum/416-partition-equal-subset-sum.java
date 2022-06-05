class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        int n = nums.length;
        
        for(int i=0;i <nums.length;i++){
            sum+=nums[i];
        }
        if(sum %2 != 0) return false;
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int[] s : dp){
            Arrays.fill(s,-1);
        }
        return subsetSum(nums.length-1,nums,sum/2,dp);
        
    }
    
    public boolean subsetSum(int index,int [] nums,int target,int[][]dp){
        if(target == 0) return true;
        if(index == 0 ) return nums[index] == target;
        if(dp[index][target] != -1) return dp[index][target]==0?false:true;
        boolean notTake = subsetSum(index-1,nums,target,dp);
        boolean take = false;
        if(target >= nums[index]){
            take = subsetSum(index-1,nums,target-nums[index],dp);
        }
        
        dp[index][target]=notTake||take?1:0;
        return notTake || take;
    }
}