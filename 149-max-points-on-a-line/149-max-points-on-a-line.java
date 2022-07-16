class Solution {
    public int maxPoints(int[][] points) {
              if(points.length == 1)
            return 1;
        
        HashMap<Double, HashSet<Integer>> countSlopes = new HashMap<Double, HashSet<Integer>>();
        int maxpoints = 0;
        for(int i = 0; i < points.length;i++)
        {
            countSlopes.clear();
            
            for(int j =  i+1; j < points.length; j++)
            {
                double slope = getSlope(points[i],points[j]);
                HashSet<Integer> pointSet = countSlopes.getOrDefault(slope, new HashSet<Integer>());
                pointSet.add(i);
                pointSet.add(j);
                countSlopes.put(slope,pointSet);
                maxpoints = Math.max(maxpoints, pointSet.size());
            }
        }
        
        return maxpoints;
    }
    
	// Y= m*X + C. return m.
    public double getSlope(int[] pointA, int[] pointB)
    {
        int Y = pointA[1]-pointB[1];
        int X = pointA[0]- pointB[0];
        
        return X == 0 ? Double.MIN_VALUE : (double)(Y)/(double)X + 0.0; // +0.0 to get rid of -0.0
    }
    
}