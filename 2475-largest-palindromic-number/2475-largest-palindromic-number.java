class Solution {
    public String largestPalindromic(String num) {
         int[] arr = new int[10];
        StringBuilder sb = new StringBuilder();
        for(char c: num.toCharArray()){
            arr[c-'0']++;                       //Counter
        }
        int mid = -1;
        boolean flag = true;
        for(int i = 9; i>=0; i--){
            if(arr[i]==0) continue;
            if(arr[i] % 2 == 1 && flag){               //get largest mid
                mid = i;
                flag = false;
            }
            if(i==0 && sb.length()==0) break;            //no leading zeros
            int t = arr[i] / 2; 
            while(t-- > 0) sb.append(i);                 // building left part
        }
        StringBuilder rev = new StringBuilder(sb).reverse();
        sb.append(rev);                                   // adding right part
        if(mid!=-1) sb.insert(sb.length()/2, mid);
        return (sb.length() == 0) ? "0" : sb.toString() ;
    }
}
