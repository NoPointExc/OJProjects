import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		String str="[1,-2,-3,1,3,-2,null,-1]";
		TreeNode root = TreeBuilder.create(str);		
		TreeBuilder.print(root);
		
		boolean ans=s.hasPathSum(root,-4);
		System.out.println(ans);
	}
}
