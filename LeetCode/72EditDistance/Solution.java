
public class Solution {
	
    public int minDistance(String word1, String word2) {
    	int l1=word1.length(), l2=word2.length();
    	int [][] dis=new int[l1+1][l2+1];
    	for(int i=0;i<=l1;i++){
    		dis[i][0]=i;
    	}
    	for(int j=0;j<=l2;j++){
    		dis[0][j]=j;
    	}

    	for(int i=1;i<=l1;i++){
    		for(int j=1;j<=l2;j++){
    			if(word1.charAt(i-1)==word2.charAt(j-1)) dis[i][j]=dis[i-1][j-1];
    			else{
    				dis[i][j]=1+Math.min((Math.min(dis[i][j-1],dis[i-1][j])),dis[i-1][j-1]);
    			}
    		}
    	}

  		return dis[l1][l2];     
    }


}