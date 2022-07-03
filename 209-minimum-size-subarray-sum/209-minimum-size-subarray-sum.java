class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len=Integer.MAX_VALUE,
        sum=0,j=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                len=Math.min(len,i-j+1);
                sum-=nums[j++];
            }
        }
        return (len==Integer.MAX_VALUE)?0:len;
    }
}