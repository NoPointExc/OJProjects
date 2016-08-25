/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if(head==null) return null;
		ListNode first=head;
		ListNode second=head;
		
		while(true){
		    first=first.next;
		    if(first==null) return null;
		    second=second.next;
		    if(second==null) return null;
		    second=second.next;
		    if(second==null) return null;
		    if(second==first) break;
		}

		first=head;
		while(first!=second){
			first=first.next;
			second=second.next;
		}

		return first;
	}
}

