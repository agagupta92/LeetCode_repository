class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
         int n = nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        int hash[] = new int[n];
        for(int i =0;i<n;i++)
            dp[i] = 1;
        int maxi = 1,lastIndex=0;
        for(int i =0;i <n;i++){
            hash[i]=i;
            for(int prev =0 ;prev<i;prev++){
                if(nums[i]%nums[prev] == 0 && 1 + dp[prev]>dp[i]){
                    dp[i] = 1+dp[prev];
                    hash[i]=prev;
                }
                if(dp[i]>maxi){
                    maxi = dp[i];
                    lastIndex =i;
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        res.add(nums[lastIndex]);
        
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            res.add(nums[lastIndex]);
        }
        for(int i =0,j= res.size()-1;i <res.size()/2;i++,j--){
            int temp = nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
        
        }
        return res;
        
        //return recu(0,-1,nums,n,dp);
    
    }
}