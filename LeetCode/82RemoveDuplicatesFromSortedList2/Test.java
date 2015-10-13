

// javac -cp .:junit-4.12.jar 
// java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore 

public class Test{
	public static void main(String[] args) {
		if(args.length>0){
			ListNode l1=new ListNode(Integer.valueOf(args[0]));
			ListNode p=l1;
			for(int i=1;i<args.length;i++){
				p.next=new ListNode(Integer.valueOf(args[i]));
				p=p.next;
			}
			print(l1);
			Solution s=new Solution();
			ListNode rst=s.deleteDuplicates(l1);
			print(rst);
		}
	}

	public static void print(ListNode ls){
		while(ls.next!=null){
			System.out.print(ls.val+"->");
			ls=ls.next;
		}
		System.out.println(ls.val);
	}
}