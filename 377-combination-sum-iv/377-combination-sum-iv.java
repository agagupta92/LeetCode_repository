class Solution {
    public int combinationSum4(int[] nums, int target) {
        return recupermute(0,nums,target,new HashMap<Integer,Integer>());
    }
    
    public int recupermute(int index,int [] nums,int target,HashMap<Integer,Integer> dp){
        if(index >= nums.length || target <=0){
            return target ==0 ? 1 : 0;
        }
        
        int currentKey = target;
        if(dp.containsKey(currentKey))
            return dp.get(currentKey);
        
        int take = recupermute(0,nums,target-nums[index],dp);
        int notTake = recupermute(index+1,nums,target,dp);
        
        dp.put(currentKey,take+notTake);
        return take + notTake;
    }
}

    
