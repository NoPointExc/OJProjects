class Test{
	public static void main(String[] args) {
		if(args.length>0){
			int[] arr=new int[args.length];
			for(int i=0;i<arr.length;i++){
				arr[i]=Integer.valueOf(args[i]);
			}
			Solution s=new Solution();
			int len=s.removeDuplicates(arr);
			System.out.println("len="+len);
		}		
	}
}