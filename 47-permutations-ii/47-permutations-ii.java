class Solution {
   public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        recupermute(0,nums,res);
        //Collections.sort(res);
        return res;
    }
    
    public void recupermute(int index,int [] nums,List<List<Integer>> ans){
        
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i =0;i <nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = index;i < nums.length;i++){
            if(shouldSwap(nums,index,i)){
                swap(nums,index,i);
                recupermute(index+1,nums,ans);
                swap(nums,index,i);
            }
        }
    }
    
    boolean shouldSwap(int str[], int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (str[i] == str[curr]) {
                return false;
            }
        }
        return true;
    }
    
    public void swap(int [] nums, int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}