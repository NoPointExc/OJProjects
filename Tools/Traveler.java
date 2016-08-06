import java.util.*;

public class Traveler{
	public void postorder(TreeNode root){
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		TreeNode cur=root;
		TreeNode last=null;
		while(!stack.isEmpty() || cur!=null){
			if(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}else{
				if(stack.peek().right!=null && stack.peek().right!=last){
					cur=stack.peek().right;
				}else{
					last=stack.pop();
					visit(last);
				}
			}

		}
	}

	public void perorder(TreeNode root){
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		if(root!=null)stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur=stack.pop();
			visit(cur);			
			if(cur.right!=null) stack.push(cur.right);
			if(cur.left!=null) stack.push(cur.left);
		}
	}

	public void inorder(TreeNode root){
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		TreeNode cur=root;
		while(cur!=null || !stack.isEmpty()){
			if(cur!=null){
				stack.push(cur);
				cur=cur.left;
			}else{
				cur=stack.pop();
				visit(cur);
				cur=cur.right;
			}
		}
	}


	/**
	 * overide this method is necessary
	 * @param node the node to visit
	 */
	public void visit(TreeNode node){
		System.out.println(node.val);
	}


}