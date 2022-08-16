class Solution {
     public int firstUniqChar(String str)
        {
            char count [] = new char[256];
            for(int i = 0; i < str.length();i++){
                count[str.charAt(i)]++;
            }
            int index = -1, i;

            for (i = 0; i < str.length(); i++) {
                if (count[str.charAt(i)] == 1) {
                    index = i;
                    break;
                }
            }

            return index;
        }
}