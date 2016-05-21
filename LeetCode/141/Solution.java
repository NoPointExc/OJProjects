public class Solution {
	public boolean hasCycle(ListNode head) {
		if(head==null) return false;
		ListNode pt=head.next;
		while(pt!=null && pt!=head){
			ListNode tmp=pt.next;
			pt.next=head;
			pt=tmp;
		}
		return pt==head;
	}
}
