class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> in = new HashMap <>();

        for(int i =0 ;i < nums.length;i++){
            in.put(nums[i],in.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<> (
            (a, b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer,Integer> entry : in.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int [] result = new int[k];
        for(int i =0 ; i < k ; i ++){
            result[i] = minHeap.poll().getKey();
        }

        return result ;
    }
}