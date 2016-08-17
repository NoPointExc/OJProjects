import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] in=new int[args.length];
		for(int i=0;i<args.length;i++){
			in[i]=Integer.valueOf(args[i]);
		}
		List<List<Integer>> ans=s.permuteUnique(in);
		System.out.println(ans);
	}
}
