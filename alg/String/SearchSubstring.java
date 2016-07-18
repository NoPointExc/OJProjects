import java.util.*;

public class SearchSubstring{

	//Z
	//Time O(m+n)
	//insert pattern as profix, search profix and use symmetry of whole string
	private int[] getZArr(char[] str, char[] pattern){
		int len=str.length+pattern.length+1;
		char[] arr=new char[len];
		for(int i=0;i<str.length;i++) arr[i]=str[i];
		arr[str.length]='$';
		for(int i=0;i<pattern.length;i++) arr[i+str.length+1]=pattern[i]; 
	
		int[] lens=new int[len];
		int k=0;
		int i=1;
		
		while(k<len){
			System.out.println(k);
			//i starting from k(substring), reach the max matched prefix
			while(k+i<len && arr[i]==arr[k+i]){
				i++;
			}
			lens[k]=i;
			//search between k<--->k+i
			int j=k+1;
			while(j<k+i){
				if(lens[j-k]<k+i){
					lens[j]=lens[j-k];
					j++;
				}else{
					k=k+i;
					i=lens[i]+1;
					break;
				}
			}
			k++;
		}
				
		return lens;
	}

	public List<Integer> zSearch(char[] str, char[] pattern){
		List<Integer> lst=new LinkedList();
		int[] arr=getZArr(str,pattern);
		int len=pattern.length;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==len){
				lst.add(i-pattern.length-1);
			}
		}
		return lst;
	}

	//KMP 
	//Time O(m+n)
	//use the symmetry of pattern to reduce track back.
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
		SearchSubstring s=new SearchSubstring();
		char[] str="colacolegoogle".toCharArray();
		char[] pattern="goo".toCharArray();
		//int[] lps=s.getTmpArr(str);
		int[] lps=s.getZArr(str,pattern);	
		for(int i:lps) System.out.print(i+" ");
		//boolean rst=s.kmp(str,pattern);
		//System.out.println(rst);
	}

}
