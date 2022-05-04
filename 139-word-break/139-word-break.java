class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true;
        
        for(int i =0;i < s.length();i++){
            
            if(!t[i])
                continue;
            
            for(String dict : wordDict){
            
            
                int len = dict.length();
                int end = i + len;

                if(end > s.length())
                        continue;
                
                if(t[end]) continue;
                
                if(s.substring(i,end).equals(dict)){
                    t[end] = true;
                }
            }
        }
        return t[s.length()];
    }
    
    
    // Recusive soultion
    
    /*public boolean wordBreakHelper(String s, List<String> wordDict,int start){
        if(start == s.length())
            return true;
        
        for(String dict : wordDict){
            
            
            int len = dict.length();
            int end = start + len;
            
            if(end > s.length())
                continue;
            
            
            if(s.substring(start,end).equals(dict)){
                if(wordBreakHelper(s,wordDict,end)){
                    return true;
                }
            }
        }
        
        return false;
    }*/
}