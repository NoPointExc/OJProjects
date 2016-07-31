import java.util.*;

class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		String str="catsanddog";
		String[] arr={"cat", "cats", "and", "sand", "dog"};
		Set<String> words=new HashSet(Arrays.asList(arr));
		List rst=s.wordBreak(str,words);
		System.out.println("rst="+rst);
	}
}