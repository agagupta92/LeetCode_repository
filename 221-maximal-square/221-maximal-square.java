class Solution {
    public int maximalSquare(char[][] A) {
        int r = A.length;
        int c = A[0].length;
        int[][] temp = new int[r][c];
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                temp[i][j] = A[i][j] - '0';
                if (temp[i][j] > 0 && i > 0 && j > 0) {
                    temp[i][j] = Math.min(temp[i - 1][j - 1], Math.min(temp[i - 1][j], temp[i][j - 1])) + 1;
                }
                maxi= Math.max(maxi,temp[i][j]);
            }
        }
        return maxi*maxi;
    }
}