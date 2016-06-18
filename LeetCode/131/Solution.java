import java.util.*;

public class Solution {
	public List<List<String>> partition(String s) {
		if(s==null) return null;
		int len=s.length();
		List<List<String>> rst=new LinkedList();
		if(len==0) return rst;
		if(len==1){
			List<String> tmp=new LinkedList();
			tmp.add(s);
			rst.add(tmp);
			return rst;
		}
		for(int i=1;i<=len;i++){
			String sub=s.substring(0,i);
			//System.out.println("sub="+sub+"left="+s.substring(i,len));
			if( isPalindrome(sub) ) {
				List<List<String>> subRst=partition(s.substring(i,len));
				if(i==len) {
					List<String> tmp=new LinkedList();
					tmp.add(sub);
					rst.add(tmp);
				}
				for(List<String> lst:subRst){
					List<String> tmp=new LinkedList();
					tmp.add(sub);
					tmp.addAll(lst);
					rst.add(tmp);
				}
			}
		}

		return rst;
	}

	private boolean isPalindrome(String str){
		int len=str.length();
		for(int i=0;i<(len-i-1);i++){
			if( str.charAt(i)!=str.charAt(len-i-1) ) return false;
		}
		//System.out.println(str+"is Palindrome");
		return true;
	}
}
