class Solution {
    public int strStr(String haystack, String needle) {
        
        int res = -1;
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        
        if (needleLen == haystackLen && needleLen == 0)
            return -1;
        
        if (needleLen == 0)
            return -1;
        
        for(int i =0;i < haystackLen;i++){
            if(haystackLen - i + 1 < needleLen){
                return -1;
            }
            
            int k = i;
            int j = 0;
            
            while(k < haystackLen  && j < needleLen && haystack.charAt(k) == needle.charAt(j)){
                k++;
                j++;
                if(j == needleLen)
                    return i;
            }
            
        }
        
        return -1;
    }
}