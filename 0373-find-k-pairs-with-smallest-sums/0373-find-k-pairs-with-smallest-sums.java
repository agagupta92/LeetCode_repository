class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> maxHeap = new PriorityQueue<> ( ( a, b ) -> a[0] - b[0]);

        for (int x : nums1){
            maxHeap.offer(new int[]{x + nums2[0],0});
        }

        while(k > 0 && !maxHeap.isEmpty()){
            int[] pair = maxHeap.poll();
            int sum = pair[0];
            int pos = pair[1];
             List<Integer> cp = new ArrayList<>();

            cp.add(sum - nums2[pos]);
            cp.add(nums2[pos]);
            result.add(cp);

            if(pos + 1 < nums2.length){
                maxHeap.offer(new int[]{sum - nums2[pos] + nums2[pos+1],pos + 1});
            }
            k--;
        }
        return result;
    }
}