import java.io.*;
class Util{
	public static String formate(int[] result){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<result.length;i++){
			sb.append("Case #");
			sb.append(i+1);
			sb.append(": ");
			sb.append(result[i]);
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void print(int[] result){
		String tmp=Util.formate(result);
		System.out.println(tmp);
	}


	public static void write( int[] result,String fileName){
		String tmp=formate(result);
		File file=new File(fileName);
		try{	
			BufferedWriter out=new BufferedWriter(new FileWriter(file));
			out.write(tmp);
			out.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static String read(String fileName){
		StringBuilder sb=new StringBuilder();
		File file=new File(fileName);
		
		try{
			BufferedReader in=new BufferedReader(new FileReader(file));
			String lin="";
			while((lin=in.readLine())!=null) {
				sb.append(lin);
				sb.append(" ");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static int[] fileToArr(String fileName){
		String file=Util.read(fileName);
		String[] tmp=file.split(" ");
		int[] input=new int[tmp.length];
		for(int i=0;i<input.length;i++){
			input[i]=Integer.valueOf(tmp[i]);
		}
		return input;
	}
}