public class Solution {
    public static String removeDuplicateLetters(String s) {
	if(s == null){
	    return null;
	}

	int[] counts = count(s, 0);
	StringBuilder builder = new StringBuilder();
	int min = 0;
	boolean[] appended = new boolean[26];

	for(int i = 0; i < s.length();){
	    //System.out.println(s);
	    counts[s.charAt(i) - 'a'] --;
	    if(s.charAt(min) > s.charAt(i) && !appended[s.charAt(i) - 'a']){
		min = i;
	    }
	    if(counts[s.charAt(i) - 'a'] == 0){
		//recount. go back after min
		System.out.println(s.charAt(min));
		builder.append(s.charAt(min));
		appended[s.charAt(min) - 'a'] = true;
		counts = count(s, min + 1);
		i = min + 1;
		min = i;
	    }else{
		i++;
	    }
	}

	return builder.toString();
    }

    private static int[] count(String s, int start){
	int[] counts = new int[26];
	for(int i = start; i < s.length(); i++){
	    counts[s.charAt(i) - 'a'] += 1;
	}
	return counts;
    }

    public static void main(String[] args){
	String str = removeDuplicateLetters("cbacdcbc");
	System.out.println(str);
	String key = "hihihi";
    }
}
