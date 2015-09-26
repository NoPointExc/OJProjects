import java.util.*;
public class BinaryTree<T>{
	public T val;
	public BinaryTree<T> left, right;
	public BinaryTree (T val){
		this.val=val;
	}

	public void insert(T node, Comparator<T> c){
		if(c.compare(val,node)<0){
			//left
			if(left==null) {
				left=new BinaryTree(node);
			}else{
				left.insert(node,c);
			}
		}else{
			//right
			if(right==null){
				right=new BinaryTree(node);
			}else{
				right.insert(node);
			}
		}
	}

	public List<BinaryTree> LevelOrderTravle(BinaryTree<T> tree ){
		List<BinaryTree> rst=new ArrayList<BinaryTree> ();
		//List<BinaryTree> level=new ArrayList<BinaryTree>();
		Deque<BinaryTree> queue=new LinkedList<BinaryTree> ();
		BinaryTree p=tree;
		//rst.add(p);
		while(p.left!=null||p.right!=null||queue.size()!=0){			
			if(p.left!=null) {
				queue.offer(p.left);
			}
			if(p.right!=null) {
				queue.offer(p.right);
			}
			if(!queue.isEmpty()){ 				
				p=queue.poll();
				rst.add(p);
			}			
		}
		return rst;
	}

}