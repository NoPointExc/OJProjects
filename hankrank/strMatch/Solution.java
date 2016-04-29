import java.util.*;

class Solution{
	public boolean find(int[] text, int[] word){
		int[] prf=new int[word.length];
		Arrays.fill(prf,-1);
		int begin=-1;
		for(int i=1;i<word.length;i++){
			while(begin>=0 && word[begin+1]!=word[i]){
				begin=prf[begin];
			}
			if(word[begin+1]==word[i]){
				begin++;
				prf[i]=begin;
			}
		}
		//System.out.println("prfix "+Arrays.toString(prf));
		
		int j=0;
		for(int i=0;i<text.length-word.length;i++){
			while(word[j]==text[i+j]){
				if(j==word.length-1) return true;
				j++;
			}
			//System.out.println("i="+i+"j="+j);
			j=prf[j]+1;
		}
		return false;
	}	
}
