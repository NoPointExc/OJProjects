import java.util.*;

class TreeBuilder{

	/**
	 * create a tree from input
	 * @param  val[] TreeNode value in level order value
	 * @return    root node
	 */
	public static TreeNode create(int vals[]){
		TreeNode nodes[]=new TreeNode[vals.length];
		//for(int val:vals) System.out.print(val+"  ");
		for(int i=0;i<vals.length;i++){
			if(vals[i]==Integer.MIN_VALUE) nodes[i]=null;
			else nodes[i]=new TreeNode(vals[i]);
		}
		
		if(vals==null||vals.length==0) return null;
		TreeNode root=nodes[0];
		int pl=0, pr=1; //cL=pR, cR=2*(pr-pl)+pl
		int cl=pr;
		while(cl<nodes.length){
			if(nodes[pl]!=null){
				nodes[pl].left=nodes[cl];				
				cl++;
				if(cl>=nodes.length) break;
				nodes[pl].right=nodes[cl];
				cl++;
				if(cl>=nodes.length) break;
			}			
			pl++;
			if(pl>=pr){
				pl=pr;
				pr=cl;
			}					
		}
		return root;
	}

	/**
	 * create a tree from string copy from Leetcode
	 * @param  vals arrays in string,e.g "[1,-2,-3,1,3,-2,null,-1]"
	 * @return      root node of create tree
	 */
	public static TreeNode create(String valStr){
		int from=valStr.indexOf('[');
		int to=valStr.indexOf(']');
		String sub=valStr.substring(from+1,to);
		String[] valStrs=sub.split(",",0);
		int vals[] =new int[valStrs.length];
		for(int i=0;i<valStrs.length;i++){
			if(valStrs[i].equals("null")) vals[i]=Integer.MIN_VALUE;
			else vals[i]=Integer.valueOf(valStrs[i]);
			//System.out.println(vals[i]);
		}
		return create(vals);
	}

	public static void print(TreeNode root){
		LevelTraver traver=new LevelTraver();
		List<List<Integer>> lst=traver.levelOrder(root);
		int depth=lst.size();

		for(int i=0;i<depth;i++){			
			List<Integer> levelLst=lst.get(i);
			int indent=(2*(depth-i)-3);
			int space=1;
			if(i==depth-1){
				indent=0;
				space=1;
			}
			//indent
			for(int j=0;j<indent;j++){
				System.out.print(" ");
			}

			//print a val
			Iterator<Integer> it=levelLst.iterator();
			while(it.hasNext()){
				int val=it.next();
				if(val==Integer.MIN_VALUE) System.out.print("#");
				else System.out.print(val);
				//space
				for(int j=0;j<space;j++) System.out.print(" ");
			}	
			System.out.println();
		}

	}

}
