public class Solution {
	public String longestCommonPrefix(String[] strs) {
		int len = strs.length;
		if (strs.length == 0) return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char prefix = strs[0].charAt(i);
			int j=0;
			for (; j < len && i < strs[j].length() && strs[j].charAt(i) == prefix ; j++);
			if (j < len) return strs[0].substring(0,i);
			}	
	return strs[0];
	}
}
