class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        int n = heights.length;
        int max = 0;
        for(int i =0;i <=n ;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]> heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width = 0;
                if(!st.isEmpty()){
                    width = i - st.peek() -1;
                } else {
                     width = i;
                }
                max = Math.max(max,height * width);
            }
            st.push(i);
        }
        return max;
        
    }
}