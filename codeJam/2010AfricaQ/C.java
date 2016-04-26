import java.io.*;
import java.util.*;

public class Solution {
	private static InputReader in;
	private static PrintWriter out;
	public static boolean SUBMIT = true;
	//public static final String NAME = "C-small-practice";
	public static final String NAME = "C-large-practice";

	private static void main2() throws IOException {
		String str=in.nextLin();
		//char[] chr=str.toCharArray();
		//System.out.println(str);
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<str.length();i++){
			int count=0;
			int num=0;
			
			if(i>0&&str.charAt(i)==str.charAt(i-1)){
				sb.append(" ");
			}
			if(str.charAt(i)==' '){
				num=0;
				count=1;
			}else if(str.charAt(i)<='o'){
				num=(str.charAt(i)-'a')/3+2;
				count=(str.charAt(i)-'a')%3+1;
			}else if(str.charAt(i)<='s'){
				num=7;
				count=(str.charAt(i)-'p')+1;					
			}else if(str.charAt(i)<='v'){
				num=8;
				count=(str.charAt(i)-'t')+1;
			}else{
				num=9;
				count=(str.charAt(i)-'w')+1;
			}

			for(;count>0;count--){
				sb.append(num);
			}
		}

		
		out.println(sb.toString());
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
