class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        recupermute(0,nums,target,ds,res);
        return res;
    }
    
    public void recupermute(int index,int [] nums,int target,List<Integer> ds,List<List<Integer>> ans){
        
            if(target ==0){
                ans.add(new ArrayList<>(ds));
                return;
            }
        
        for(int i = index;i < nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;
                ds.add(nums[i]);
                recupermute(i+1,nums,target-nums[i],ds,ans);
                ds.remove(ds.size()-1);
        }
        
    }
}