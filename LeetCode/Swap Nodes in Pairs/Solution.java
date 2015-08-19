
public class Solution {
    public ListNode swapPairs(ListNode head) {     	
      	ListNode point=new ListNode(-1);
      	point.next=head;
      	ListNode tmp=point;
      	boolean isHead=true;
      	while(point.next!=null){ 
   			print(tmp.next);
      		if(isHead){
      			point.next=swap(point.next);
      		}
      		isHead=!isHead;
      		point=point.next;
      		      	}
        return tmp.next;
    }

   	public ListNode swap(ListNode head){
   		if(head.next==null) return head;
   		ListNode tmp=head;
   		head=head.next;
   		tmp.next=head.next;
   		head.next=tmp;
   		return head;
   	}

   	public void print(ListNode head){
   		StringBuilder sb=new StringBuilder("");
   		while(head!=null){
   			sb.append(head.val);
   			sb.append(">");
   			head=head.next;
   		}
   		System.out.println(sb.toString());
   	}
}