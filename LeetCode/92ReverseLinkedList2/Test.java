class Test{
	public static void main(String[] args) {
		ListNode zero=new ListNode(0);
		ListNode h=zero;
		int m=Integer.valueOf(args[0]);
		int n=Integer.valueOf(args[1]);
		for(int i=1;i<2;i++) {
			ListNode next=new ListNode(i);
			h.next=next;
			h=h.next;
		}
		Solution s=new Solution();
		ListNode rst=s.reverseBetween(zero.next,m,n);
		System.out.println(rst);
	}


}