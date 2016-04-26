import java.io.*;
import java.util.*;

public class A {
	private static InputReader in;
	private static PrintWriter out;
	public static boolean SUBMIT = true;
	//public static final String NAME = "A-small-practice";
	public static final String NAME = "A-large-practice";

        static void main2() throws IOException {
                int linNum=in.nextInt();
                int[][] pos=new int[linNum][2];
		HashSet<List> set=new HashSet<>();
                for(int i=0;i<linNum;i++ ){
                        pos[i][0]=in.nextInt();
                        pos[i][1]=in.nextInt();
                }
                //calculate all inter points.
                for(int i=0;i<linNum;i++){
                        double a0=(double)pos[i][0];
                        double b0=(double)pos[i][1];
                        for(int j=i+1;j<linNum;j++){
                                double a1=(double)pos[j][0];
                                double b1=(double)pos[j][1];
								double x=(a0-a1)/(b1-b0+a0-a1);
								double y=x*(b0-a0)+a0;
								double [] itPoint={x,y};
								//System.out.println("a0"+a0+" b0"+b0+"  ;a1"+a1+" b1"+b1+"  ;x="+x+" y="+y);
								if(x>0 && x<1){
									set.add(Arrays.asList(itPoint));
								}
                        }
                }
				out.println(set.size());
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
