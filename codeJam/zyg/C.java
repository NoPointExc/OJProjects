import java.io.*;
import java.util.*;

public class C {
	//private static String fileName = "C-large-practice";
	private static String fileName = "C-small-practice";	
	private static String inputFileName = fileName + ".in";
	private static String outputFileName = fileName + ".out";
	private static Scanner in;
	private static PrintWriter out;

	private void solve() {

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
			new C().solve();
		}
		in.close();
		out.close();
	}
}
