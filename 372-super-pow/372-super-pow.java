class Solution {
    public int superPow(int a, int[] b) {
    int[] buf = new int[10];
        buf[0] = 1;
        a = a%1337;
        for(int i =1;i<10;i++){        
            buf[i] = (buf[i-1]*a)%1337;
        }
        int ans = buf[b[0]], temp;
        for(int i = 1;i<b.length;i++){
            ans = (ans*ans)%1337;   
            temp = ans;
            ans = (ans*ans)%1337;
            ans = (ans*ans)%1337;
            ans = (ans*temp)%1337;
            ans = (ans*buf[b[i]])%1337;
        }
        return ans;
    }
}