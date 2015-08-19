class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		ListNode head=new ListNode(0);
		ListNode pointer=head;
		for(int i=1;i<10;i++){
			pointer.next=new ListNode(i);
			pointer=pointer.next;
		}
		s.print(head);
		ListNode ans= s.reverseKGroup(head,4);
		s.print(ans);
	}
}