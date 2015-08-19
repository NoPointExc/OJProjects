
import java.util.*;
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode point=new ListNode(-1);
		point.next=head;
		ListNode ans=point;
		while(point.next!=null){
			ListNode tmp=reverse(point.next,k);
			if(tmp!=null)point.next=tmp;
			else break;
			
			for(int i=0;i<k;i++){
				if(point.next!=null) point=point.next;	
				else break;			
			}
		}
		return ans.next;
	}

	public ListNode reverse(ListNode head, int k){
		ListNode point=head;
		ListNode ans=new ListNode(-1);
		ArrayList<Integer> list= new ArrayList <Integer>(k);
		for(int i=0;i<k;i++){
			if(point==null) return null;
			list.add(point.val);
			point=point.next;
		}
		ListNode tmp=point;
    	//reverse
		point=ans;
		for(int i=k-1;i>-1;i--){
			point.next= new ListNode(list.get(i)); 
			point=point.next;
		}
		point.next=tmp;
		return ans.next;
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