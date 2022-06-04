class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        recu(0,n,temp,ans,nums);
        return ans;
    }
    
    public void recu(int ind,int n ,List<Integer> ds,List<List<Integer>> ans,int[] nums){
        ans.add(new ArrayList<>(ds));
        
        for(int i = ind; i < n; i++){
            ds.add(nums[i]);
            recu(i+1,n,ds,ans,nums);
            ds.remove(ds.size()-1);
        }
        
    }
}