import java.util.*;
class Test{
	public static void main(String[] args) {
		if(args.length>1){
			Solution s=new Solution();
			//s.combine(6,2);
			List<List<Integer>> ans=s.combine(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
			System.out.println(ans);
		}
	}
}