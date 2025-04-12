class Solution {

    int [] nums = { 1,2,3,4,5,6,7,8,9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        
        recupermute(0,nums,k,n,ds,res);
        return res;
    }

    public void recupermute(int index,int [] nums,int k,int target,List<Integer> ds,List<List<Integer>> ans){
        
            if(target == 0 && ds.size() == k){
                ans.add(new ArrayList<>(ds));
                return;
            }
        
        for(int i = index;i < nums.length;i++){
            
            if(nums[i] > target || ds.size() > k) break;
                ds.add(nums[i]);
                recupermute(i+1,nums,k,target-nums[i],ds,ans);
                ds.remove(ds.size()-1);
        }
        
    }
}
