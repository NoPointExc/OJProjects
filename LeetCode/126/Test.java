import java.util.*;

class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		String from="hot";
		String to="dog";
		HashSet<String> dict=new HashSet();
		String[] toAdd={"hot","dog"};
		for(String str:toAdd){
			dict.add(str);
		}
		List<List<String>> ans = s.findLadders(from,to,dict);
		System.out.println(ans);	
	}
}