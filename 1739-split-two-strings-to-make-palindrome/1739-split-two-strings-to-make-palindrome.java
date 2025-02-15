class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
      
      return validate(a,b) || validate(b,a);
    }
    
    private boolean validate(String a, String b) {
        int l = 0, r = a.length()-1;
        while (l < r) {
            if (a.charAt(l) != b.charAt(r)) 
                break; 
            l++;
            r--;
        }
        
        return  validate(a,l,r) || validate(b,l,r);
    }
    
    private boolean validate( String a, int l, int r )
    {
         while (l < r) {
            if (a.charAt(l) != a.charAt(r)) 
                break; 
            l++;
            r--;
        }
    return l >=r;
    }
}