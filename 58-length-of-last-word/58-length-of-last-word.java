class Solution {
    public int lengthOfLastWord(String s) {
        
        String[] strArr = s.trim().split(" ");
        return strArr[strArr.length-1].length();
        
    }
}