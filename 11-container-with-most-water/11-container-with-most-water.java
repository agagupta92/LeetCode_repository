class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            // Move the shorter lines each time
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

            // update the max area
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
        }

        return max;
    }
}