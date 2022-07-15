class Solution {
     static int ROW, COL, count;
    public  int maxAreaOfIsland(int[][] grid) {
        
        int area = 0;
        
        for(int i =0; i < grid.length ; i++)
            for(int j=0; j < grid[0].length ; j++)
                if(grid[i][j] == 1)
                    area = Math.max(area, dfs(grid, i,j));
        return area;
    }
    
    int dx[] = new int[]{0,0,1,-1};
    int dy[] = new int[]{1,-1,0,0};
    
    int dfs(int[][] grid, int sr, int sc){
        
        if(sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || grid[sr][sc] != 1)
            return 0;
        
        int area = 0;
        grid[sr][sc] =2; // Marking as visit
        area += dfs(grid, sr + dx[0], sc + dy[0]);
        area += dfs(grid, sr + dx[1], sc + dy[1]);
        area += dfs(grid, sr + dx[2], sc + dy[2]);
        area += dfs(grid, sr + dx[3], sc + dy[3]);
        
        area +=1;
        return area;
    }
}