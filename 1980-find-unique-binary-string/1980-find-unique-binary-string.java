class Solution {
    public String findDifferentBinaryString(String[] nums) {
         StringBuilder st = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            if(nums[i].charAt(i) == '1') st.append('0');
            else st.append('1');
        }
        return st.toString();
    }
}