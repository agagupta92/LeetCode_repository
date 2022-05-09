class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();
            beginSet.add(beginWord);
            endSet.add(endWord);
            Set<String> dict = new HashSet<>(wordList);
            if(!dict.contains(endWord)) return 0;
            return search(beginSet, endSet, dict, true, 1);
        }
    
    private int search(Set<String> beginSet, Set<String> endSet, Set<String> dict, boolean isForward, int cnt){
        if(beginSet.isEmpty() || endSet.isEmpty()) return 0;
        cnt++;
        dict.removeAll(beginSet);
        Set<String> nextSet = new HashSet<>();
        for(String str : beginSet){
            char[] chs = str.toCharArray();
            for(int i = 0; i < chs.length; i++){
                char c = chs[i];
                for(char j = 'a'; j <= 'z'; j++){
                    chs[i] = j;
                    String tmp = new String(chs);
                    if(!dict.contains(tmp)) continue;
                    if(endSet.contains(tmp)) return cnt;
                    nextSet.add(tmp);
                }
                chs[i] = c;
            }
        }
        return nextSet.size() > endSet.size() ? search(endSet, nextSet, dict, false, cnt) : search(nextSet, endSet, dict, true, cnt);
    }
}
        
        
        
       /* if (dict.size() == 0)
            return 0;
          
          LinkedList<String> wordQueue = new LinkedList<String>();
          LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        
          wordQueue.add(start);
          distanceQueue.add(1);

        
  //track the shortest path
  int result = Integer.MAX_VALUE;
  while (!wordQueue.isEmpty()) {
    String currWord = wordQueue.pop();
    Integer currDistance = distanceQueue.pop();
    if (currWord.equals(end)) {
       result = Math.min(result, currDistance);
    }
      
    for (int i = 0; i < currWord.length(); i++) {
       char[] currCharArr = currWord.toCharArray();
       for (char c = 'a'; c <= 'z'; c++) {
           currCharArr[i] = c;
         String newWord = new String(currCharArr);
         if (dict.contains(newWord)) {
               wordQueue.add(newWord);
               distanceQueue.add(currDistance + 1);
               dict.remove(newWord);
            } 
        }
    } 
  }
      if (result < Integer.MAX_VALUE)
        return result;
      else
        return 0;
    
     
        
        
     // Brute force solution   
     /*int len=0;
      HashSet<String> visited = new HashSet<String>();
      for(int i=0; i<start.length(); i++){
         char[] startArr = start.toCharArray();
         for(char c='a'; c<='z'; c++){
            if(c==start.toCharArray()[i]){
                continue; 
            }
            startArr[i] = c;
            String temp = new String(startArr);
            if(dict.contains(temp)){
               len++;
               start = temp;
               if(temp.equals(end)){
                    return len; 
               }
            } 
         }
        }
        return len;
    }
}*/





