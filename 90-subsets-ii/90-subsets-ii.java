class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
         Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        recu(0,n,temp,ans,nums);
        return ans;
    }
    
    public void recu(int ind,int n ,List<Integer> ds,List<List<Integer>> ans,int[] nums){
        ans.add(new ArrayList<>(ds));
        
        for(int i = ind; i < n; i++){
            if(i != ind && nums[i] == nums[i-1])
                continue;
            ds.add(nums[i]);
            recu(i+1,n,ds,ans,nums);
            ds.remove(ds.size()-1);
        }
        
    }
}