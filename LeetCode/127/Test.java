import java.util.*;

class Test{
	public static void main(String[] args){
		String from="red";
		String to="tax";
		String[] dict={"ted","tex","red","tax","tad","den","rex","pee"};
		Solution s=new Solution();
		int rst=s.ladderLength(from,to,new HashSet(Arrays.asList(dict)));
		System.out.println(rst);
	}

}