class Solution {
     public int removeDuplicates(int[] nums) {
         int count = 1,curr = 1;
        for(int i =1;i < nums.length;i++){
            if(nums[i-1] != nums[i]){
                count++;
                nums[curr++] = nums[i];
            }
        }
        return count;
    }
    
    /*public int removeDuplicates(int[] nums) {
        Set<Integer> st = new TreeSet<>();
        
        for(int i =0;i < nums.length;i++)
            st.add(nums[i]);
        
        int i = 0;
        Iterator itr = st.iterator();
         while(itr.hasNext())
            nums[i++] = (Integer) itr.next();
        
        
        return st.size();
    }*/
}