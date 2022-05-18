class Solution {
    public List<String> generateParenthesis(int n) {
        
        ArrayList<String> result = new ArrayList<String>();
  ArrayList<Integer> diff = new ArrayList<Integer>();
  result.add("");
  diff.add(0);
  for (int i = 0; i < 2 * n; i++) {
    ArrayList<String> temp1 = new ArrayList<String>();
      ArrayList<Integer> temp2 = new ArrayList<Integer>();
    for (int j = 0; j < result.size(); j++) {
       String s = result.get(j);
       int k = diff.get(j);
       if (i < 2 * n - 1) {
         temp1.add(s + "(");
         temp2.add(k + 1);
        }
       if (k > 0 && i < 2 * n - 1 || k == 1 && i == 2 * n - 1) {
         temp1.add(s + ")");
         temp2.add(k - 1);
        } 
    }
    result = new ArrayList<String>(temp1);
    diff = new ArrayList<Integer>(temp2);
  }
  return result;

    }
}