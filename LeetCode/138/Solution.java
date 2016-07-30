/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null) return null;
		HashMap<RandomListNode,RandomListNode> map=new HashMap();
		RandomListNode cpHead=new RandomListNode(head.label);
		map.put(head,cpHead);
		RandomListNode pc=cpHead;
		RandomListNode pt=head;
		while(pt.next!=null){
			pc.next=new RandomListNode(pt.next.label);
			pc=pc.next;
			pt=pt.next;
			map.put(pt,pc);
		}

		pc=cpHead;
		pt=head;

		while(pt!=null){
			pc.random=map.get(pt.random);
			pc=pc.next;
			pt=pt.next;
		}

		return cpHead;
	}
}
