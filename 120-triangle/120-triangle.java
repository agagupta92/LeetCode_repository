class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      int[] total = new int[triangle.size()];
      int l = triangle.size() - 1;
      for (int i = 0; i < triangle.get(l).size(); i++) {
        total[i] = triangle.get(l).get(i);
        }
        System.out.println("each");
      // iterate from last second row
      for (int i = triangle.size() - 2; i >= 0; i--) {
        for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
           total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
            }
        }
  return total[0];
}
}