public class Main{
	private static int[] pan={0,3,1,2};
	public static void main(String[] args) {
		Pan mpan=new Pan(pan);
		int min=mpan.getMinStep();
		System.out.println();
		System.out.println("RESULT:  "+min);
	}


}