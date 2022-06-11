class Solution {
    public boolean checkPartitioning(String sp) {
        char[] str = sp.toCharArray();
        int n = str.length;
        boolean [][] dp = new boolean [n][n];
        for(boolean[]d : dp)
            Arrays.fill(d,false);
        
        /* dp[i][j] is true if str[i...j] is palindrome */
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                int len = j - i + 1;
                if(len == 1) {
                    dp[i][j] = true;
                }
                else if(len == 2) {
                    dp[i][j] = (str[i] == str[j]);
                }
                else {
                    dp[i][j] = (str[i] == str[j]) && (dp[i + 1][j - 1]);
                }
            }
        }
        
        for(int p = 0; p < n; p++) {
            for(int s = p + 2; s < n; s++) {
                boolean left = dp[0][p];
                boolean mid = dp[p + 1][s - 1];
                boolean right = dp[s][n - 1];
                if(left && mid && right) {
                    return true;
                }
            }
        }
        
        return false;
    }
}