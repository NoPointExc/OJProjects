public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        if(len1+len2!=s3.length()) return false;
        boolean[][] matched=new boolean[len1+1][len2+1]; 
        //init
        matched[0][0]=true;
        for(int i=0;i<len1;i++) matched[i+1][0]= matched[i][0]&&s1.charAt(i)==s3.charAt(i);
        for(int i=0;i<len2;i++) matched[0][i+1]= matched[0][i]&&s2.charAt(i)==s3.charAt(i);
        for(int i=1;i<matched.length;i++){
        	for(int j=1;j<matched[0].length;j++){
        		matched[i][j]= (matched[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)) || ( matched[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
        		//System.out.print(matched[i][j]+" ");        		
        	}
        	//System.out.println();
        }
        
        return matched[len1][len2];
    }
}

// s1(i),s2(j)
// i,j

// i+j+1:-->s1(i+1);
// i+j+1:-->s2(j+1);

