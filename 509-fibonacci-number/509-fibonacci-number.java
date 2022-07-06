class Solution {
    public int fib(int n) {
       
        return recufib(n);
    }
    
    public int recufib(int n){
         if(n <= 0)
            return 0;
        if(n ==1 )
            return 1;
        return recufib(n-1) + recufib(n-2);
    }
}