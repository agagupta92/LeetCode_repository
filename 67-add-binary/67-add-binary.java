class Solution {
    public String addBinary(String a, String b) {
       StringBuffer str = new StringBuffer();
        int carry =0;
        int n = a.length()-1,m = b.length()-1;
        while(n >=0 || m >=0){
            int sum = carry; 
            if(n >=0) sum += a.charAt(n--) - '0';
            if(m >=0) sum += b.charAt(m--) - '0';
            str.append(sum %2 );
            carry = sum/2;
        }
        if (carry != 0) str.append(carry);
        return str.reverse().toString();
    }
}

