public class Solution {
	int count=0;
	int n=0;
    public int totalNQueens(int n) {
    
       	this.n=n;
        char[][] map=new char[n][n];
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		map[i][j]='.';
        	}	
        }

        put(map,0);
        
        return count;        
    }

   	private void put(char[][] map, int index){
    	//print(map);
    	if(index==n){
    		index=0;
    		count++;    		
    	}
    	for(int i=0;i<n;i++){    		
			if(scan(map,index,i)){
				map[index][i]='Q';
				put(map,index+1);
				map[index][i]='.';
			}    			    			    		
    	}
    	
    }

    private boolean scan(char[][] map,int x,int y){
    	for(int i=0;i<n;i++){
    		if(map[x][i]!='.') return false;
    		if(map[i][y]!='.') return false;
    		if(x+i<n && y+i<n && map[x+i][y+i]!='.') return false;
    		if(x-i>-1 && y-i>-1 && map[x-i][y-i]!='.') return false;
    		if(x+i<n && y-i>-1 && map[x+i][y-i]!='.') return false;
    		if(x-i>-1 && y+i<n && map[x-i][y+i]!='.') return false;
    	}
    	return true;

    }

}