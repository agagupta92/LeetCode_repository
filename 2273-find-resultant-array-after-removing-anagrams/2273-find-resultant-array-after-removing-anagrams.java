class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prev = "";
        
         for (int i = 0; i < words.length; i++) {
             if(!isAnagram(words[i],prev)){
                 ans.add(words[i]);
             }
             prev = words[i];
             
         }
        return ans;
    }
    
    public boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        //store frequency of s1 and s2. for s1 character add 1 and for s1 subtract 1
        int[] freq = new int[26];
        // prepare freq map till s1 length
        for (int i = 0; i < s1.length(); i++) {
			freq[s1.charAt(i) - 'a'] += 1;
			freq[s2.charAt(i) - 'a'] -= 1;
		}
        
        return checkAnagram(freq);
    }
    //check if freq map has all zero. it will be true for anagram
    private boolean checkAnagram(int[] freq) {
        for(int i=0;i<freq.length;i++) {
            if(freq[i]!=0) {
                return false;
            }
        }
        return true;
    }
}