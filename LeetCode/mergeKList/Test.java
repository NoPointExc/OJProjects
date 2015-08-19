class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		ListNode h1=new ListNode(0);
		ListNode h2=new ListNode(1);
		ListNode p1=h1;
		ListNode p2=h2;
		for(int i=1;i<10;i++){
			p1.next=new ListNode(2*i);
			p2.next=new ListNode(2*i+1);
			p1=p1.next;
			p2=p2.next;
		}
		ListNode lists[]={h1,h1,h2,h1,h2};
		ListNode ans= s.mergeKLists(lists);
		System.out.println("**ANS**");
		print(ans);	

	}

	private static void print(ListNode l){
		while(l!=null){
			System.out.print(l.val+", ");
			l=l.next;
		}
		System.out.println();
	}
}