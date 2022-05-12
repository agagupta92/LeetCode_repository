/*class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        double ans = 1.0;
        if(n < 0) nn = -nn;
        while(nn > 0){
            if(nn % 2 == 1){
                ans = ans * x;
            } else {
                x = x * x;
                nn= nn/2;
            }
        }
        
        if(n < 0){
            ans = (double)1.0/(double)ans;
        }
        return ans;
    }
}*/


class Solution {
    public double myPow(double x, int n) {
        return power(x,n);
    }
    
     double power(double x, int y){
        double temp;
        if( y == 0)
            return 1;
        temp = power(x, y/2); 
          
        if (y%2 == 0)
            return temp*temp;
        else
        {
            if(y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    } 
}