class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        solve(0,temp,ans,s);
        return ans;
    }
    
    public void solve(int index,List<String> temp,List<List<String>> ans,String s){
        if(index == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = index;i < s.length();i++){
            if(isPalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                solve(i+1,temp,ans,s);
                temp.remove(temp.size()-1);
            }
        }
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