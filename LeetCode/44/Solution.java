public class Solution {
    public boolean isMatch(String s, String p) {
        int len=s.length();
        int wid=p.length();

        boolean[][] map=new boolean[wid+1][len+1];
        map[0][0]=true;
        for(int i=1;i<=len;i++)
        	map[0][i]=map[0][i-1] && s.charAt(i-1)=='*';
        for(int i=1;i<=wid;i++)
        	map[i][0]=map[i-1][0] && p.charAt(i-1)=='*';
        

        for(int i=1;i<=wid;i++){
        	for(int j=1;j<=len;j++){
        		if(isEqual(p.charAt(i-1),s.charAt(j-1)) && map[i-1][j-1])
        			map[i][j]=true;
        		else if(map[i][j-1] && (s.charAt(j-1)=='*' || p.charAt(i-1)=='*' ) )
        			map[i][j]=true;
        		else if(map[i-1][j] &&(p.charAt(i-1)=='*' || s.charAt(j-1)=='*' ) )
        			map[i][j]=true;
        		else map[i][j]=false;
        	}
        }

        return map[wid][len];
    }

    private boolean isEqual(char a1,char a2){
    	return a1=='*'||a2=='*'||a1=='?'||a2=='?'||a1==a2;
    }
}