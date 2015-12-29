//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    @Override
    public String toString(){
    	ListNode p=this;
    	StringBuilder sb=new StringBuilder();
    	while(p.next!=null){
    		sb.append(p.val);
    		sb.append("->");
    		p=p.next;
    	}
    	sb.append(p.val);
    	return sb.toString();
    }
}
