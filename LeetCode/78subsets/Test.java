import java.util.*;
class Test{
	public static void main(String[] args) {
		if(args.length>0){
			int[] nums=new int[args.length];
			
			for(int i=0;i<args.length;i++){
				nums[i]=Integer.valueOf(args[i]);
			}

			Solution s=new Solution();
			List<List<Integer>> ans= s.subsets(nums);
			System.out.println(ans);
		}
	}
}