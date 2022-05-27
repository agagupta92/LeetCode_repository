class Solution {
   public int countSubstrings(String s) {
	var count = 0;
	for (var i = 0; i < s.length(); i++)
		count += countSubstrings(s, i, i) + countSubstrings(s, i, i + 1);
	return count;
}

private int countSubstrings(String s, int start, int end) {
	var count = 0;
	while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) 
		count++;
	return count;
}
}