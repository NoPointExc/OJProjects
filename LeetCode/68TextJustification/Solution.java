import java.util.*;
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        int wdLen=0, wdNum=0;//spc=maxWidth-wdLen;
        List<String> wdLin=new ArrayList<String>();
        List<String> rst=new ArrayList<String>();
        //debug
        // for(int i=0;i<words.length;i++){
        // 	System.out.println(i+". "+words[i]+", len="+words[i].length()+" ; ");
        // }
        
        //debug

        for(int i=0;i<words.length;){ 
        	//System.out.println("i="+i+" wdLen="+wdLen+" wdNum="+wdNum);       	
    	   	if((wdLen+wdNum-1+words[i].length())<maxWidth){
        		wdLin.add(words[i]);
        		wdLen+=words[i].length();
        		wdNum++;
        		i++;
        	}else{
        		String newLin=addLin(wdLin,maxWidth-wdLen, wdNum, maxWidth);
        		rst.add(newLin);
        		wdLin.clear();
        		wdLen=0;
        		wdNum=0;
        	}
        	if(i==words.length){
        		//last
        		StringBuilder sb=new StringBuilder();
        		Iterator<String> it=wdLin.iterator();
        		while(it.hasNext()){
        			sb.append(it.next());
        			if(sb.length()<maxWidth) sb.append(" ");
        		}
        		sb.append(space(maxWidth-sb.length()));
        		//String newLin=addLin(wdLin,maxWidth-wdLen, wdNum, maxWidth);
        		rst.add(sb.toString());
        		break;
        	}     	
        }

        return rst;

    }

    private String addLin(List<String> wdLin,int spc, int wdNum, int maxWidth){
    	Iterator<String> it=wdLin.iterator();
    	int[] spcs =new int[1];
    	spcs[0]=spc;
    	if(wdNum>1) spcs=new int[wdNum-1];	  	
    	StringBuilder sb=new StringBuilder();
    	for(int i=(wdNum-1);i>0;i--){	 
			spcs[i-1]=spc/i;
			spc-=spcs[i-1];
    	}

    	for(int i=0;it.hasNext();i++){
    		String thisWd=it.next();
    		sb.append(thisWd);
    		if(i<spcs.length) sb.append(space(spcs[i]));    		
    	}
    	return sb.toString();    	
    }

    private String space(int num){
    	System.out.println("num="+num);
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<num;i++){
    		sb.append(' ');
    	}
    	return sb.toString();
    }
}