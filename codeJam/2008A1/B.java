import java.io.*;
import java.util.*;

public class B {
	//private static String fileName = "B-large-practice";
	private static String fileName = "B-small-practice";	
	private static String inputFileName = fileName + ".in";
	private static String outputFileName = fileName + ".out";
	private static Scanner in;
	private static PrintWriter out;
	
	int[][] choice;
	int cust;
	private void solve() {
		int flavor=in.nextInt();
		cust=in.nextInt();
		boolean[] isHappy=new boolean[cust];
		Arrays.fill(isHappy,false);
		int[] milk=new int[flavor];
		Arrays.fill(milk,0);
		choice=new int[flavor][cust];
		for(int i=0;i<flavor;i++){
			Arrays.fill(choice[i],-1);//-1 don't care 
		}
		//get solution
		int rst=minMalted(0,milk,isHappy);
		if(rst==-1){
			out.println("IMPOSSIBLE");
		}else{
			for(int i=0;i<flavor;i++){
				out.print(milk[i]+" ");
			}
			out.println();
		}			
	}

	private int minMalted(int from,int[] milk,boolean[] isHappy){
		if(from==milk.length){
			for(int i=0;i<isHappy.length;i++){
				if(!isHappy[i]) return -1;
			}
			return 0;
		}
		boolean mayMalted=false;
		
		//UN-Malted
		boolean[] isHappyTmp=Arrays.copyOf(isHappy,isHappy.length);
		int[] milkTmp=Arrays.copyOf(milk,milk.length);
		//ask every customer && try unmalted
		for(int i=0;i<cust;i++){
			//not happy & like malted
			if(!isHappy[i]){
				if(choice[from][i]==0){
					isHappyTmp[i]=true;
				}else{
					mayMalted=true;
				}
			}
		}
		//int[] milkTmp=Arrays.copyOf(milk,milk.length);
		int rst=minMalted(from+1,milkTmp,isHappyTmp);
		
		//MALTED
		if(mayMalted){
			int[] milkMal=Arrays.copyOf(milk,milk.length);
			milkMal[from]=1;
			boolean isHappyMal[]=Arrays.copyOf(isHappy,isHappy.length);
			//ask every customer if become happy
			for(int i=0;i<isHappy.length;i++){
				if(!isHappy[i]&&choice[from][i]==1){
					isHappyMal[i]=true;
				}
			}
			int rstMal=minMalted(from+1,milkMal,isHappyMal);
			if(rst>0 && rst>rstMal) rst=rstMal;
		}
		
		return rst;	
		
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
			new B().solve();
		}
		in.close();
		out.close();
	}
}
