class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
       List<String> dp[] = new ArrayList[s.length()+1];
       dp[0] = new ArrayList<String>();
        
           for(int i=0; i<s.length(); i++){
              if( dp[i] == null )
                    continue;
              for(String word:wordDict){
                 int len = word.length();
                 int end = i+len;
                 if(end > s.length())
                    continue;
                 if(s.substring(i,end).equals(word)){
                    if(dp[end] == null){
                       dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                 }
                } 
           }
        
        List<String> result = new LinkedList<String>();
        if(dp[s.length()] == null)
            return result;
        
        
        ArrayList<String> temp = new ArrayList<String>();
       dfs(dp, s.length(), result, temp);
       return result;
        
        
    }
    
    public void dfs(List<String> dp[],int end,List<String> result,ArrayList<String> tmp){
        
        //once all the words are added in to the temp array iterator the temp array in reverse order and construct the statement and add it into the result.
        if(end <= 0){
          String path = tmp.get(tmp.size()-1);
          for(int i=tmp.size()-2; i>=0; i--){
             path += " " + tmp.get(i) ;
          }
          result.add(path);
          return; 
        }
        
        //starting from the end of dp array take all the words and add it to temp List
        for(String str : dp[end]){
          tmp.add(str);
        //again call the dfs for the remaing words list
          dfs(dp, end-str.length(), result, tmp);
          tmp.remove(tmp.size()-1);
        }
    }
}