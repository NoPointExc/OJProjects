public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        int wdLen=0, wdNum=0;//spc=maxWidth-wdLen;
        List<String> wdLin=new ArrayList<String>();
        List<String> rst=new ArrayList<String>();
        for(int i=0;i<words.length;){        	
    	   	if(wdLen+wdNum-1+words[i]<maxWidth){
        		wdLin.add(words[i])
        		wdLen+=words[i].length;
        		wdNum++;
        		i++;
        	}else{
        		String newLin=addLin(wdLin,maxWidth-wdLen, wdNum, maxWidth);
        		rst.add(newLin);
        		wdLin.clear();
        		wdLen=0;
        	}      	
        }
        
        return rst;

    }

    private String addLin(List<String> wdLin,int spc, int wdNum, int maxWidth){
    	Iterator it=wdLin.Iterator();
    	int spcs[]=new int[wdNum];
    	StringBuilder sb=new StringBuilder();

    	for(int i=wdNum;i>0;i--){	 
			spcs[i-1]=spc/i;
			spc-=spcs[i-1];
    	}

    	while(int i=0;it.hasNext();i++){
    		String thisWd=wdLin.next();
    		sb.append(thisWd);
    		if(i<spcs.length) sb.append(space(spcs[i]));    		
    	}
    	return sb.toString();    	
    }

    private String space(int num){
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<num;i++){
    		sb.append(' ');
    	}
    	return sb.toString();
    }
}