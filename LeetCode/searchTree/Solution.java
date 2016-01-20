 public class Solution{
	public void travel(TreeNode root){
		TreeNode cur=root;
		//List<Integer> lst=new ArrayList<Integer>();
		while(cur!=null){
			//if left node is null
			if(cur.left==null) {
				//System.out.println(cur.val);
				//lst.add(cur.val);
				cur=cur.right;
			}
			else{				
				TreeNode next=cur.left;
				//go to right most of in hte left children
				while(next.right!=null &&next.right!=cur)
					next=next.right;
				if(next.right==null){
					next.right=cur;
					cur=cur.left;
				}else{
					next.right=null;
					//System.out.println(cur.val);
					//lst.add(cur.val);
					cur=cur.right;
				}
			}			
		}
	}
}