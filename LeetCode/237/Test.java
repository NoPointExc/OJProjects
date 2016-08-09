import java.util.*;

class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		ListNode root=new ListNode(1);
		ListNode p=root;
		for(int i=2;i<6;i++){
			p.next=new ListNode(i);
			p=p.next;
		}
		s.deleteNode(root.next);
		p=root;
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
	}
}