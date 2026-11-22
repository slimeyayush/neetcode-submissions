class Solution {
    public int largestRectangleArea(int[] heights) {
        //  1 pops 7 (height = 7)(1 - (-1) - 1) (i - peekIndex - 1); 
        //  1 7 -> 2 pops 7 (height = 7) (3 - 1 - 1) (calc height for popped current becomes it's right wall peek becomes it's left wall)
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        for(int i=0; i<n; i++) {
            int h =heights[i];
            while(!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int leftWall = (stack.isEmpty())? -1:stack.peek();
                int width = (i - leftWall - 1);
                maxArea = Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int popped = stack.pop();
            int left = (stack.isEmpty())? -1:stack.peek();
            int area = heights[popped]*(n - left - 1);
            maxArea = Math.max(area,maxArea);
        }

        return maxArea;
        
    }
}
