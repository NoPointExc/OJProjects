/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode insertionSortList(ListNode head) {
		ListNode rst = new ListNode(-1);
		ListNode root =new ListNode(-1);
		root.next = head;
		ListNode prst = rst;
		
		while(root.next != null){
			ListNode befMin = null;
			ListNode p = root;
			
			while(p.next != null){
				if(befMin==null || befMin.next.val>p.next.val){
					befMin = p;
				}

				p = p.next;
			}

			prst.next = befMin.next;
			//remove from orgin
			befMin.next = befMin.next.next;
			prst = prst.next;
			prst.next = null;
		}
		
		return rst.next;
	}
}
