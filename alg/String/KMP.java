public class KMP{

	//
	private int[] getTmpArr(char[] pattern){
		int len=pattern.length;
		int[] lps=new int[len];

		int index=0;
		int i=1;
		while(i<len){
			if(pattern[i]==pattern[index]){
				lps[i]=index+1;
				i++;
				index++;
			}else{
				if(index!=0) index=lps[index];
				else{
					lps[i]=0;
					i++;
				}
			}
		}

		return lps;
	}

	public boolean kmp(char[] str, char[] pattern){
		int[] lps=getTmpArr(pattern);
		
		int i=0,j=0;
		while(i<str.length && j<pattern.length){
			if(str[i]==pattern[j]){
				i++;
				j++;
			}else{
				if(j!=0){
					j=lps[j-1];
				}else{
					i++;
				}
			}
		}
		
		return j==pattern.length;
	}

	public static void main(String[] args){
		KMP s=new KMP();
		char[] str="colacolegoogle".toCharArray();
		char[] pattern="goo".toCharArray();
		int[] lps=s.getTmpArr(str);
		for(int i:lps) System.out.print(i+" ");
		boolean rst=s.kmp(str,pattern);
		System.out.println(rst);
	}

}
