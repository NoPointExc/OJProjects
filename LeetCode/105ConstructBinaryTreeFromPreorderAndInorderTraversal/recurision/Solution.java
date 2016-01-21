import java.util.*;
//cant't be arry, must delete after inserted.
public class Solution {
	int[] preorder,inorder;
	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||preorder.length!=inorder.length) return null;
        this.preorder=preorder;
        this.inorder=inorder;
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return buildTree(0,preorder.length-1,0);
    }

    private TreeNode buildTree(int head,int tail,int rootPos){
        //System.out.println("head="+preorder[head]+", tail="+preorder[tail]+" root="+inorder[rootPos]);
        if(rootPos>=preorder.length || rootPos<0 || head>tail) return null;
        //System.out.println("head="+inorder[head]+", tail="+inorder[tail]+" root="+preorder[rootPos]);
      
        TreeNode root=new TreeNode(preorder[rootPos]);
        if(head==tail) return root;
        int mid=map.get(preorder[rootPos]);
        root.left=buildTree(head,mid-1,rootPos+1);
        root.right=buildTree(mid+1,tail,rootPos+mid-head+1);
        return root;
    }


    public void travel(TreeNode cur){
        if(cur==null) return;
        System.out.println(cur.val);
        travel(cur.left);
        travel(cur.right);
    }
}