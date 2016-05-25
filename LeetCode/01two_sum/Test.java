public class Test{

	

	public static void main(String[] args) {
		int[] numbers={1,5,25,75,65};
		int target=100;
		Solution s=new Solution();
		System.out.println("*********ANS*******");
		int[] ans=s.twoSum(numbers, target);
		//int ans=s.binary_search(numbers, 0, 3,4);
		//System.out.println("ans="+ans);
		System.out.println("index1="+ans[0]+"  index2="+ans[1]);
	}




}



