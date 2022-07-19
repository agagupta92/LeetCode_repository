class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> row = null,prev = null;
        
        for(int i = 0; i < numRows;i++){
            row = new ArrayList<Integer>();
            for(int j = 0 ; j <= i ;j++){
                if(j == i || j == 0){
                    row.add(1);
                } else {
                    row.add(prev.get(j-1) + prev.get(j));
                }
            }
            ans.add(row);
            prev = row;
        }
        
        return ans;
    }
}