class Solution {
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if (board==null ||board.length==0||board[0].length==0) return false;
        int m=board.length,n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for (int i=0;i< m;i++){
            for (int j=0;j<n;j++){               
                if (dfs(board,visited,i,j,0,word)){
                    return true;
                }              
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, int x, int y, int i, String word){         
        int m=board.length,n=board[0].length;   
        if (i==word.length()) return true;
        
        if(x<0||x>=m||y<0||y>=n) return false;
        if(visited[x][y]) return false;
        if(board[x][y]!=word.charAt(i)) return false;
        
        visited[x][y]=true;
        for (int[] dir: dirs){
            int x1=x+dir[0], y1=y+dir[1];
            if (dfs(board, visited, x1, y1, i+1, word)){
                return true;
            }
        }
        visited[x][y]=false;
        return false;                                                                          
    }
}