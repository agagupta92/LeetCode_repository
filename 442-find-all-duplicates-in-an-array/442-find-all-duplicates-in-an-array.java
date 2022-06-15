class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            int index = Math.abs(i);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            } else {
               res.add(index);
            }
        }
        return res;
    }
}