class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globmin = nums[0];
        int globmax = nums[0];
        int curmin = 0, curmax = 0, total =0;

        int res = globmax;

        for(int i=0;i < nums.length;i++){
            curmax = Math.max(curmax + nums[i], nums[i]);
            curmin = Math.min(curmin + nums[i], nums[i]);

            total += nums[i];

            globmax = Math.max(globmax,curmax);
            globmin = Math.min(globmin,curmin);
            
            if(globmax > 0){
                res = Math.max(globmax, total- globmin);
            }  else {
                res = globmax;
            }
        }

        return res;
    }
}