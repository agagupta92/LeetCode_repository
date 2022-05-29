class Solution {
    
    public boolean check(String s1,String s2){
        if(s1.length() != s2.length()+1)
            return false;
        int first=0,second=0;
        while(first <s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            } else {
                first++;
            }
        }
        
        if(s1.length() == first && second == s2.length())
            return true;
        return false;
    }
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        int n = words.length;
        int dp[] = new int[n];
        for(int i =0;i<n;i++)
            dp[i] = 1;
        int maxi = 1;
        for(int i =0;i <n;i++){
            
            for(int prev =0 ;prev<i;prev++){
                if(check(words[i],words[prev]) && 1 + dp[prev]>dp[i]){
                    dp[i] = 1+dp[prev];
                    
                }
                if(dp[i]>maxi){
                    maxi = dp[i];
                }
            }
        }
        return maxi;
    }
}


/*class Solution {
    
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
}*/