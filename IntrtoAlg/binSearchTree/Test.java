import java.util.*;
public class Test{
	public static void main(String[] args) {
		if(args.length>0){
			BinaryTree<Integer> bt=new BinaryTree<Integer>(5);
			//form tree
			for(int i=0;i<args.length;i++){
				int num=Integer.valueOf(args[i]);
				BinaryTree<Integer> p=bt;
				while(p!=null){
					if(num<p.val){						
						if(p.left==null) {
							//System.out.println("<<"+num);
							p.left=new BinaryTree<Integer> (num); 
							break;
						}
						p=p.left;
					}else{
	
						if(p.right==null) {
							//System.out.println(">>"+num);
							p.right=new BinaryTree<Integer> (num);
							break;
						}
						p=p.right;
					}
				}
			}
			List<BinaryTree> levels=bt.LevelOrderTravle(bt);
			Iterator<BinaryTree> it=levels.iterator();
			while(it.hasNext()){
				BinaryTree<Integer> node=it.next();
				//System.out.println(node.val);
			}			
		}
	}
}