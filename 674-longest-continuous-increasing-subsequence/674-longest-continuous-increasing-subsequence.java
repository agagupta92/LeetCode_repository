class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int mcf = 1,mcth = 1;
        int initalval = nums[0];
        for(int i =1;i<nums.length;i++){
            if(initalval < nums[i]){
                mcth++;
                
            }else {
                mcth =1;
            }
            initalval = nums[i];
            mcf = Math.max(mcf,mcth);
        }
        
        return mcf;
        
    }
}