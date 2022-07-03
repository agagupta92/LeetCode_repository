class Solution {
    public int wiggleMaxLength(int[] a) {
        if(a.length < 2) return a.length;
    
        int i = 1; while(i < a.length && a[i] == a[i-1]) i++;
        if(i == a.length) return 1;

        int c = 2;
        boolean inc = a[i] > a[i-1];
        while(i < a.length) {
            if(inc) {
                while(i < a.length && a[i] >= a[i-1]) i++;
                if(i < a.length) c++; inc = false;
            }
            else {
                while(i < a.length && a[i] <= a[i-1]) i++;
                if(i < a.length) c++; inc = true;
            }

        }
        return c;
    }
}