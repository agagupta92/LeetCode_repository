class Solution {

      int fib(int n, int dp[])
    {
        if(n<=2)
         return n;
       
    
       int  prev=2;
        int prev2=1;
        int cur = 0;
            

            for(int i = 3;i <= n ;i++){
                cur = prev + prev2;
                
                prev2 = prev;
                prev = cur;

            }

        return prev;
    }
    
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
      
        return fib(n,dp);
        

    }
}