import java.util.*;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
		LinkedList<List<Integer>> list=new LinkedList<List<Integer>>();
		LinkedList<Integer> pthList=new LinkedList<Integer>();
		int curSum=0; //the sum of the nodStack
		LinkedList<TreeNode> nodStack=new LinkedList<TreeNode>();

		if(root==null) return list;
		TreeNode cur=root;
		while(cur!=null||!nodStack.isEmpty()){
			if(cur!=null){
			//go left
				nodStack.push(cur);
				curSum+=cur.val;
				pthList.add(cur.val);
				cur=cur.left;
			}else{				
				cur=nodStack.pop();					
				if(cur.left==null && cur.right==null){					
					//System.out.print("sum="+curSum);
					System.out.print("*");																						
				}
				System.out.println(cur.val);
				//System.out.print(nodStack);				
				//go right
				cur=cur.right;														
			}
		}
		return list;
    }
    
}