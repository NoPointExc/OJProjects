class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		ListNode head=new ListNode(0);
		ListNode pt=head;
		for(int i=1;i<9;i++){
			pt.next=new ListNode(i);
			pt=pt.next;
		}
		s.print(head);
		ListNode ans=s.swapPairs(head);
		//s.print(ans);
	}
}