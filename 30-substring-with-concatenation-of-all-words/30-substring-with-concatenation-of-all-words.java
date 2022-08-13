class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int res=0,i,lens=s.length(),lenw=words[0].length(),n=words.length,j;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(String w : words) map.put(w,map.getOrDefault(w,0)+1);
        
        HashMap<String,Integer> hashmap = new HashMap<String,Integer>();;
        for(i=0;i<=(lens-lenw*n);i++){
            hashmap.clear();
            for(j=0;j<n;j++){
                String str = s.substring(i+lenw*j,i+lenw*(j+1));
                hashmap.put(str,hashmap.getOrDefault(str,0)+1);
                if(map.getOrDefault(str,Integer.MIN_VALUE)<hashmap.get(str)) break;
            }
            if(j==n) list.add(i);
        }
        return list;
    }
}