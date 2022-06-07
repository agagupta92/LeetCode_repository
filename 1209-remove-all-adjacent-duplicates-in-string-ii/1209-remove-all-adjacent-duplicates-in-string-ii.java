class Solution {
    public String removeDuplicates(String S, int k) {
        Deque<Character> charStk = new ArrayDeque<>();
        Deque<Integer> cntStk = new ArrayDeque<>();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if (charStk.isEmpty() || charStk.peek() != c) { // no char in stack yet, or top char is different from the current.
                charStk.push(c);
                cntStk.push(1);
            }else if (cntStk.peek() + 1 < k) { // top char is same as the current, but less than k after appending the current.
                cntStk.push(cntStk.pop() + 1);
            }else { // found k-in-a-row duplicates, remove them.
                charStk.pop();
                cntStk.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charStk) {
            int cnt = cntStk.pop();
            while (cnt-- > 0) {
                sb.append(c);
            }
        }
        return sb.reverse().toString(); //reverse() it.
    }
}