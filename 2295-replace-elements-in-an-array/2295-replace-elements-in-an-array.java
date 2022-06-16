class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> index = new HashMap<>();
        for(int i =0;i <nums.length;i++){
            index.put(nums[i],i);
        }
        for(int i =0;i<operations.length;i++){
            int[] j = operations[i];
            int ind = index.get(j[0]);
            index.remove(j[0]);
            index.put(j[1],ind);
        }
        
        for (Map.Entry<Integer, Integer> entry : index.entrySet()) {
           nums[entry.getValue()] = entry.getKey();
        }
        return nums;
        
    }
}