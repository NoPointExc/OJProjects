import java.io.*;
import java.util.*;

public class B {
	//private static String fileName = "B-large-practice";
	private static String fileName = "B-small-practice";	
	private static String inputFileName = fileName + ".in";
	private static String outputFileName = fileName + ".out";
	private static Scanner in;
	private static PrintWriter out;
	
	private void solve() {
		int flvNum=in.nextInt();
		int ctmNum=in.nextInt();
	
		int[] flvs=new int[flvNum];
		for(int i=0;i<flvs.length;i++){
			flvs[i]=i+1;
		}

		ArrayList<Customer> ctms=new ArrayList<Customer>();
		//System.out.println("flvNUm:"+flvNum+" ctmNum:"+ctmNum+" ctms:"+ctms);
		for(int i=0;i<ctmNum;i++){
			int wtNum=in.nextInt();
			Customer ctm=new Customer();
			//System.out.println("wtNum:"+wtNum);
			for(int j=0;j<wtNum;j++){
				int flavor=in.nextInt();
				int isMalt=in.nextInt()==0?-1:1; //-1 indicates umalted, 1 indicates malted
				ctm.want(flavor*isMalt);	
			}
			ctms.add(ctm);
		}
		
		int[] menu=Arrays.copyOf(flvs,flvs.length);
		int rst=setMenu(0,menu,ctms);	
		
		if(rst!=-1){
			for(int i=0;i<menu.length;i++){
				int tmp=menu[i]>0?1:0;
				out.print(tmp+" ");
			}
			out.println();
		}else{
			out.println("IMPOSSIBLE");
		}	
					
	}

	private int setMenu(int from,int[] menu,ArrayList<Customer> ctms){
		if(ctms.size()==0){
			return 0;
		}
		if(from==menu.length){
			return -1;	
		}
		// try malted
		int[] menuTmp0=Arrays.copyOf(menu,menu.length);
		ArrayList<Customer> ctmsTmp0=copyCtms(ctms);
		Iterator<Customer> it=ctmsTmp0.iterator();
		while(it.hasNext()){
			Customer cur=it.next();
			boolean isDrink=cur.drink(menuTmp0[from]);
			if(isDrink) it.remove();
		}
		int rst0=setMenu(from+1,menuTmp0,ctmsTmp0);//need to +1 latter
		
		//try un-malted
		int[] menuTmp1=Arrays.copyOf(menu,menu.length);
		menuTmp1[from]=-menuTmp1[from];
		ArrayList<Customer> ctmsTmp1=copyCtms(ctms);
		it=ctmsTmp1.iterator();
		while(it.hasNext()){
			Customer cur=it.next();
			boolean isDrink=cur.drink(menuTmp1[from]);
			if(isDrink) it.remove();
		}
		int rst1=setMenu(from+1,menuTmp1,ctmsTmp1);
		
		int rst=-1;
		if(rst0==-1){
			rst=rst1;
		}else if(rst1==-1){
			rst=rst1;
		}else{
			if(rst0<rst1){
				rst=rst0+1;
			}else{
				rst=rst1;
				menu[from]*=-1;
			}
		}
		return rst;	
	}

	private ArrayList<Customer> copyCtms(ArrayList<Customer> ctms){
		ArrayList<Customer> tmp=new ArrayList<Customer>();
		for(int i=0;i<ctms.size();i++){
			tmp.add(ctms.get(i).getCopy());
		}
		return tmp;
	}

	class Customer{
		HashSet<Integer> want;
		
		public Customer(){
			this.want=new HashSet<>();
		}

		public Customer getCopy(){
			Customer tmp=new Customer();
			tmp.want=this.want;
			return tmp;
		}

		void want(int milk){
			want.add(milk);
		}

		boolean drink(int milk){
			if(want.contains(milk)){
				want.clear();
			}
			return want.isEmpty();
		}
		
		boolean hasMilk(){
			return want.isEmpty();
		}	
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
