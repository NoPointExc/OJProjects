class Test{
	public static void main(String[] args) {
		ListNode head=new ListNode(0);
		ListNode pt=head;
		for(int i=1;i<1000;i++){
			pt.next=new ListNode(i);
			pt=pt.next;
		}
		Solution s=new Solution();
		head=s.reverseList(head);
		while(head!=null){

			System.out.print(head.val);
			head=head.next;
		}
	}
}