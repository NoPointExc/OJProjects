class Test{
	public static void main(String[] args) {
		int n=Integer.valueOf(args[0]);
		ListNode head=new ListNode(-1);
		ListNode cur=head;
		for(int i=0;i<n;i++){
			cur.next=new ListNode(i);
		}
		Solution s=new Solution();

	}
}