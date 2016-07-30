import java.util.*;

public class MatchStr{

	//Z
	//Time O(m+n)
	//insert pattern as profix, search profix and use symmetry of whole string
	private int[] getZArr(char[] str, char[] pattern){
		int len=str.length+pattern.length+1;
		char[] arr=new char[len];
		for(int i=0;i<pattern.length;i++) arr[i]=pattern[i];
		arr[pattern.length]='$';
		//for(int i=0;i<str.length;i++) arr[i+pattern.length+1]=str[i]; 
                //for(char c:arr) System.out.print(c);
                System.out.println();	
		int[] lens=new int[len];
		lens[0]=0;
                int k=1;
		while(k<len){
			//i starting from k(substring), reach the max matched prefix
			int i=0;
                        while(k+i<len && arr[i]==arr[k+i]){
				i++;
			}
			lens[k]=i;
			//search between k<--->k+j
			int j=1;
                        while(j<lens[k]){
				if(lens[j]<lens[k]){
                                	lens[k+j]=lens[j];
					j++;
				}else{
					k=j;
					i=lens[j];
					j=1;
                                        i=0;
                                        break;
				}
			}
                        k++;
		}
				
		return lens;
	}

	public List<Integer> zMatch(char[] str, char[] pattern){
		List<Integer> lst=new LinkedList<Integer>();
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
	private int[] getKMPArr(char[] pattern){
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

	public boolean kmpMatch(char[] str, char[] pattern){
		int[] lps=getKMPArr(pattern);
		
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
		char[] str="golagolegooglegogoo".toCharArray();
		char[] pattern="goo".toCharArray();
		//int[] lps=s.getTmpArr(str);
		//int[] lps=s.getZArr(str,pattern);	
		List<Integer> lst=s.zMatch(str,pattern);
                for(int i:lst) System.out.print(i+" ");
		System.out.println();
                //boolean rst=s.kmp(str,pattern);
		//System.out.println(rst);
	}

}
