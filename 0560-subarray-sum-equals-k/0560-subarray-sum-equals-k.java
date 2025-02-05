class Solution {
    public int subarraySum(int[] nums, int K) {
        int result = 0,sum = 0;
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);

        for(int i =0 ;i < nums.length; i++){
            sum += nums[i] ;
            if(preSum.containsKey(sum-K)){
                result += preSum.get(sum-K);
            }

            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }

        return result;
    }
}