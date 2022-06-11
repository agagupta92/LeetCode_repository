class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,0);
        for(int i = n-1;i>=0;i--){
            int mincost = Integer.MAX_VALUE;
            for(int j =i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    int cost = 1 + dp[j+1];
                    mincost = Math.min(mincost,cost);
                }
            }
            dp[i] = mincost; 
        }
        return dp[0]-1;
    }
    public int func(int i,int n ,String s,int[]dp){
        if(i ==n) return 0;
        if(dp[i] != -1) return dp[i];
        int mincost = Integer.MAX_VALUE;
        for(int j =i;j<n;j++){
            if(isPalindrome(s,i,j)){
                int cost = 1 + func(j+1,n,s,dp);
                mincost = Math.min(mincost,cost);
            }
        }
        return dp[i] = mincost; 
    }
    boolean isPalindrome(String s,int start,int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;end--;  
        }
        return true;
    }
}