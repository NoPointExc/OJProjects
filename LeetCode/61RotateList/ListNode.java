 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      
      @Override
      public String toString(){
      	ListNode tmp=this;
      	StringBuilder sb=new StringBuilder();
      	while(tmp.next!=null){
      		sb.append(tmp.val);
      		sb.append("->");
      		tmp=tmp.next;
      	}
      	sb.append("NULL");
      	return sb.toString();
      }
  }
 