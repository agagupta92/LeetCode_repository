class Solution {
    public int minCost(int n, int[] cuts) {
        int [] temp = new int[cuts.length+2];
        temp[0] = 0;
        int m =1;
        for(int i =0;i<cuts.length;i++){
            temp[m]=cuts[i];
            m++;
        }
        temp[m]=n;
        int c = cuts.length;
        Arrays.sort(temp);
        int[][] dp = new int[c+1][c+1];
        for(int []d:dp){
            Arrays.fill(d,-1);
        }
       return func(1,c,temp,dp);
    }
    
    public int func(int i ,int j,int[]cuts,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
                for(int ind =i;ind<=j;ind++){
                    int cost = cuts[j+1]-cuts[i-1]+func(i,ind-1,cuts,dp)+func(ind+1,j,cuts,dp);
                    mini = Math.min(mini,cost);
                }
                return dp[i][j] = mini;
    }
}



/*
 int [] temp = new int[cuts.length+2];
        int c = cuts.length;
        temp[0] = 0;
        int m =1;
        for(int i =0;i<cuts.length;i++){
            temp[m]=cuts[i];
            m++;
        }
        temp[m]=n;
        Arrays.sort(temp);
        System.out.print(temp.length);
         System.out.println(n);
         System.out.println(c);
        int[][] dp = new int[c+2][c+2];
        for(int []d:dp){
            Arrays.fill(d,0);
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int ind =i;ind<=j;ind++){
                    int cost = cuts[j+1]-cuts[i-1]+dp[i][ind-1]+dp[ind+1][j];
                    mini = Math.min(mini,cost);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][c];
        */