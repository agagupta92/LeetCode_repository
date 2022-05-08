class Solution {
    HashMap<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> lists = getLists(set, s);
        return lists;
    }

    private List<String> getLists(Set<String> set, String s) {
        List<String> res = new ArrayList<>();
        if (memo.containsKey(s)) {
            return memo.get(s);
        }  
        if (s.equals("")) {
            res.add("");
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            String right = s.substring(i);
            if (set.contains(right)) {
                List<String> lefts = getLists(set, s.substring(0, i));
                for (String left : lefts) {
                    if (left.equals("")) {
                        res.add(right);
                    } else {
					    // StringBuilder improves performance a lot
                        StringBuilder sb = new StringBuilder();
                        sb.append(left);
                        sb.append(" ");
                        sb.append(right);
                        res.add(sb.toString());
                    } 
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}