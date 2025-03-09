class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1 ; i < n ; i = i +3){
            if (nums[i] != nums[i-1]){
                return nums[i-1];
            }
            
        }
        return nums[n-1];
    }
}