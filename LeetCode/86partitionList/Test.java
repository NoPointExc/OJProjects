class Test{
	public static void main(String[] args) {
		ListNode head=new ListNode(-1);
		ListNode p=head;
		if(args.length>0){
			for(int i=0;i<args.length;i++){
				p.next=new ListNode(Integer.valueOf(args[i]));
				p=p.next;
			}
			Solution s=new Solution();
			ListNode rst=s.partition(head.next,3);
			while(rst!=null){
				System.out.print(rst.val+"->");
				rst=rst.next;
			}
		}
	}
}