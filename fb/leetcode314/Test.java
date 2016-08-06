import java.util.*;

class Test{
	public static void main(String[] args) {
		String str="[3,9,20,null,null,15,7]";
		
		TreeNode root = TreeBuilder.create(str);

		TreeBuilder.print(root);
		
		Solution s=new Solution();
		List<List<Integer>> rst=s.verticalOrder(root);
		System.out.println(rst);
	}
}