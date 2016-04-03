import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		String str="[1,2,3,4]";
		TreeNode root = TreeBuilder.create(str);		
		TreeBuilder.print(root);
		
		List<List<Integer>> ans=s.pathSum(root,4);
		System.out.println(ans);
	}
}
