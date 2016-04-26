import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;

public class A {
	private static InputReader in;
	private static PrintWriter out;
	public static boolean SUBMIT = true;
	//public static final String NAME = "A-small-practice";
	public static final String NAME = "A-large-practice";

	public static int textNum=0;
	public static int textLen=0;
	public static String[] texts;
	private static void main2() throws IOException {
		int matchNum=textNum;
		boolean[] isMatch=new boolean[textNum];
		for(int i=0;i<textNum;i++){
			isMatch[i]=true;
		}
		String patternStr=in.nextLin();

		for(int i=0;i<textNum;i++){
			int p=0;
			String text=texts[i];
			boolean option=false;
			boolean jump=false;
			for(int j=0;j<patternStr.length();j++){
				char cur=patternStr.charAt(j);
				if(cur=='('){
					option=true;
					jump=false;
					continue;//jump to next char
				}else if(cur==')'){
					option=false;
					if(!jump) {
						matchNum--;
						break;
					}else{
						p++;
 	                    continue;
					}
				}
				if(option){
					jump=jump||text.charAt(p)==cur;	
				}else{
					if(text.charAt(p)!=cur){
						matchNum--;
						break;//jump to next text
					}
					p++;//text.charAt P = cur
				}
			}
			
		}
		out.println(matchNum);
	}

	public static void main(String[] args) throws IOException {
			
		if (SUBMIT) {
			in = new InputReader(new FileInputStream(new File(NAME + ".in")));
			out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + ".out")));
		} else {			
			in = new InputReader(System.in);
			out = new PrintWriter(System.out, true);
		}
		textLen=in.nextInt();		
		textNum=in.nextInt();
		int numCases = in.nextInt();
		//save all texts
		texts=new String[textNum];
		for(int i=0;i<textNum;i++){
			texts[i]=in.nextLin();
		}
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
