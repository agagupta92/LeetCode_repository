class Solution {
    public int getSum(int a, int b) {
        
        if (a >= 0 && b > 0) {
            while (b != 0) {
                a++;
                b--;
            }
            return a;
        }
        if (a < 0) {
            while (b != 0) {
                a++;
                b--;
            }
        }
        if (b < 0) {
            while (b != 0) {
                b++;
                a--;
            }
        }
        return a;
    }
}