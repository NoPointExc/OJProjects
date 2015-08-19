public class Test{
	static ListNode input=null;
	static ListNode tail=null;
	static int[] leftArr={3};
	static int[] rightArr={5};
	static int[] inputArr={3,5,7,9,1,2,6,8,10};

	
	private static ListNode init(int[] in){
		input=new ListNode(in[0]);
		ListNode p=input;
		for(int i=1;i<in.length;i++){
			ListNode next=new ListNode(in[i]);
			p.next=next;
			p=next;
		}
		return input;	
	}
	private static void print(ListNode ln, String tag){
		System.out.println("********"+tag+"**********");
		while(ln!=null){
			System.out.print(ln.val+",  ");
			ln=ln.next;
		}
		System.out.println();
		System.out.println("*********************");
	}

	public static void main(String[] args) {
		sortListTest();
	}



	private static void sortListTest(){
		ListNode input=init(inputArr);
		print(input,"input");
		Solution s=new Solution();
		ListNode ans=s.sortList(input);
		print(ans, "ANS");
	}

	private static void mergeTest(){
		ListNode left=init(leftArr);
		ListNode right=init(rightArr);
		print(left,"left");
		print(right,"right");
		Solution s=new Solution();
		ListNode ans=s.merge(left, right);	
		print(ans,"ans");
	}




}