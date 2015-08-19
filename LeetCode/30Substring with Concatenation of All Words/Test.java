import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		String[] words={"foo", "bar"};
		List<Integer> ans =s.findSubstring("barfoothefoobarman",words);
		System.out.println(ans);
	}
}