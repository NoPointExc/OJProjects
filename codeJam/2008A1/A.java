import java.io.*;
import java.util.*;

public class Solution {
	private static InputReader in;
	private static PrintWriter out;
	public static boolean SUBMIT = true;
	//public static final String NAME = "A-small-practice";
	public static final String NAME = "A-large-practice";

	private static void main2() throws IOException {
		int len=in.nextInt();
		long arr0[]=new long[len];
		long arr1[]=new long[len];
		for(int i=0;i<len;i++){
			arr0[i]=(long)in.nextInt();
		}

		for(int i=0;i<len;i++){
			arr1[i]=(long)in.nextInt();
		}

		Arrays.sort(arr0);
		Arrays.sort(arr1);

		long rst=0;
		for(int i=0;i<len;i++){
			rst+=arr0[i]*arr1[len-1-i];
		}

		out.println(rst);
	}

	public static void main(String[] args) throws IOException {
			
		if (SUBMIT) {
			in = new InputReader(new FileInputStream(new File(NAME + ".in")));
			out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + ".out")));
		} else {			
			in = new InputReader(System.in);
			out = new PrintWriter(System.out, true);
		}

		int numCases = in.nextInt();
		for (int test = 1; test <= numCases; test++) {
			out.print("Case #" + test + ": ");
			main2();
		}

		out.close();
		System.exit(0);
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String nextLin(){
			String line=null;
			try{
				line=reader.readLine();
			}catch(IOException e){
				throw new RuntimeException(e);
			}
			return line;
		}
	}

}