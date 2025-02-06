class Solution {
    public int findMaxLength(int[] nums) {
        int zero = 0;
        int one = 0;
        int res = 0;

        HashMap<Integer,Integer> diff_index = new HashMap<Integer,Integer>();

        for (int i =0 ;i < nums.length; i++){
            if (nums[i] == 0)
                zero++;
            else 
                one++;
            if (!diff_index.containsKey(one - zero))
                diff_index.put(one - zero,i);

            if (one == zero){
                res = one + zero;
            }  else {
               int  idx = diff_index.get(one - zero);
                res = Math.max(res,i - idx);
            }
        }

        return res;
    }
}