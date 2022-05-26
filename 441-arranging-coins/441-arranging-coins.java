class Solution {
    public int arrangeCoins(int n) {
        if(n==1) return 1;
        int count =0;
        int i = 1;
        while(n > 0){
            if(n-i >= 0){
                n = n-i;
                i++;
                count++;
            } else{
                break;
            }
        }
        
        return count;
    }
}