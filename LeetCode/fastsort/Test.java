public class Test{
	public static void main(String[] args) {
		Sort sort=new Sort();
		int[] arr=new int[args.length];
		for(int i=0;i<args.length;i++)
			arr[i]=Integer.valueOf(args[i]);
		int[] ans=sort.quickSort(arr);
		for(int i:ans) System.out.print(i+",");
		System.out.println();
	}
}