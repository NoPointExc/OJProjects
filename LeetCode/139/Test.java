import java.util.*;

class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		String str="leetbarrcodebar";
		String[] arr={"leet","code","bar","r","barr"};
		Set<String> words=new HashSet(Arrays.asList(arr));
		boolean rst=s.wordBreak(str,words);
		System.out.println("rst="+rst);
	}
}