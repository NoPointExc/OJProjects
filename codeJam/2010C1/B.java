import java.io.*;
import java.util.*;

public class B {
	private static String fileName = "B-large-practice";
	//private static String fileName = "B-small-practice";	
	private static String inputFileName = fileName + ".in";
	private static String outputFileName = fileName + ".out";
	private static Scanner in;
	private static PrintWriter out;

	private static void  solve() {
		long l=in.nextLong();
		long p=in.nextLong();
		long c=in.nextLong();
		//System.out.println(l+";"+p+";"+c);
		int ans=0;

		while(l<p){
			ans++;
			l=l*c;
		}
		ans=32-Integer.numberOfLeadingZeros(ans-1);	
		out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		if (args.length >= 2) {
			inputFileName = args[0];
			outputFileName = args[1];
		}
		in = new Scanner(new FileReader(inputFileName));
		out = new PrintWriter(outputFileName);
		int tests = in.nextInt();
		in.nextLine();
		for (int t = 1; t <= tests; t++) {
			out.print("Case #" + t + ": ");
			solve();
		}
		in.close();
		out.close();
	}
}
