class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin =1,curMax =1;
        for(int i =1;i < nums.length;i++){
            if(res < nums[i]){
                res = nums[i];
            }
        }
        for(int i =0;i < nums.length;i++){
            if(nums[i] == 0){
                curMin =1;curMax =1;
                continue;
            }
            else {
                int tmp = nums[i]*curMax;
                curMax = Math.max(nums[i]*curMax,nums[i]*curMin);
                curMax = Math.max(curMax,nums[i]) ;
                
                curMin= Math.min(tmp,nums[i]*curMin);
                curMin= Math.min(curMin,nums[i]);
                
                res = Math.max(res,curMax);
            }
        }
        
        return res;
    }
}