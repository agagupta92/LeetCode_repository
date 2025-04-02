class Solution {
    public int[] singleNumber(int[] nums) {
        long xorr = 0;
        // XOR all numbers to get the XOR of the two unique numbers
        for (int num : nums) {
            xorr ^= num;
        }

        // Find the rightmost set bit in xorr
        long rightmost = xorr & -xorr;

        long b1 = 0, b2 = 0;

        // Divide numbers into two groups based on the rightmost set bit
        for (int num : nums) {
            if ((num & rightmost) != 0) { // Corrected condition
                b1 ^= num;
            } else {
                b2 ^= num;
            }
        }

        // Convert long to int for the result array
        int[] result = {(int) b1, (int) b2};

        return result;
    }
}