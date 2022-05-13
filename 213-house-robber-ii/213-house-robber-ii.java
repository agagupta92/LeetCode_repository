class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        int[] temp1 = new int[nums.length-1];
        int[] temp2 = new int[nums.length-1];
        for(int i =0;i < nums.length;i++){
            if(i != 0){
                temp1[i-1] = nums[i];
            }
            if(i != nums.length-1){
                temp2[i] = nums[i];
            }
        }
        
        return Math.max(rob1(temp1),rob1(temp2));
    }
    
    
    public int rob1(int[] nums) {
        int dp[] = new int [nums.length];
            
        Arrays.fill(dp,-1);
        return recu(nums.length-1,nums,dp);
    }
    
    
    public int recu(int index,int [] nums,int dp[]){
        if(index == 0) return nums[index];
        
        if(index < 0) return 0;
            
        if(dp[index] != -1) return dp[index];
        int pick = nums[index] + recu(index-2,nums,dp);
        int nonpick = 0 + recu(index-1,nums,dp);
        
        return dp[index] = Math.max(pick,nonpick);
    }
}