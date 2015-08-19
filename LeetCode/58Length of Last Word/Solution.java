public class Solution {
    public int lengthOfLastWord(String s) {
        char seq[]=s.toCharArray();
        int j=seq.length;
        int i;
        for(i=0;i<seq.length;i++){
        	if(seq[i]==' ') {
        		j=i;
        		while(i+1<seq.length && seq[i+1]==' ') i++;
        	}
        }
        while(i<seq.length && seq[i]!=' ') i++;
        j=i+1;
        return j;
    }
}