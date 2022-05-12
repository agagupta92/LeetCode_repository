class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int result = 0;
        Arrays.sort(nums);
        for(int i =0;i < n;i++){
            int j  = i+1;
            int k = n-1;
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                int diff = Math.abs(sum-target);
                
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if(sum <= target){
                    j++;
                } else{
                    k--;
                }
            }
        }
        
        return result;
    }
}