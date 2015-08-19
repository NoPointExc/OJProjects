import java.util.*;
public class Solution {
	int n=0;
	List<List<String>> res=new ArrayList<List<String>> (); 
    public List<List<String>> solveNQueens(int n) {
       	this.n=n;
        char[][] map=new char[n][n];
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		map[i][j]='.';
        	}	
        }

        put(map,0);
        
        return res;
    }

    private void put(char[][] map, int index){
    	//print(map);
    	if(index==n){
    		index=0;
    		save(map);    		
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

    private void save(char[][] map){
    	List<String> sol=new ArrayList<String>();
    	for(int i=0;i<map.length;i++){
    		StringBuilder sb=new StringBuilder();		
    		for(int j=0;j<map.length;j++){
    			if(map[i][j]=='Q') sb.append('Q');
    			else sb.append('.');
    		}    		
    		sol.add(sb.toString());
    	}
    	res.add(sol);
    }	


    private void print(char[][] map){
    	for(int i=0;i<map.length;i++){
    		for(int j=0;j<map.length;j++){
    			System.out.print(map[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println("--------");
    }
}