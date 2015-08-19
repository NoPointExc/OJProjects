import java.util.*;
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans=new ArrayList<Integer>();
        if(words.length==0 ) return ans;
        int len=s.length();
      	int wdl=words[0].length();
      	if(len<wdl*words.length) return ans;
      	Map<String,Integer> dict=new HashMap<String,Integer>();
      	for(int i=0;i<words.length;i++) {
      		if(dict.containsKey(words[i])){
      			dict.put(words[i],dict.get(words[i])+1);
      		}else{
      			dict.put(words[i],1);
      		}
      	}      	
      	Map<String,Integer> record=new HashMap<String,Integer>();
      	int recNum=0;
      	for(int i=0;i<=len-wdl;i++){
      		String sub=s.substring(i,i+wdl);
      		//System.out.println("sub:"+sub);    	
      		if(dict.containsKey(sub) && (len-i)/wdl>words.length-1){
      			//System.out.println("************");
      			int j=i;
      			while(dict.containsKey(sub) && (!record.containsKey(sub)||record.get(sub)<dict.get(sub))&&recNum<=words.length){
      				recNum++;
      				if(record.containsKey(sub)){
      					record.put(sub,record.get(sub)+1);
      				}else{
      					record.put(sub,1);
      				}
      				j+=wdl;
      				if(j>len-wdl) break;
      				sub=s.substring(j,j+wdl);      				
      			}
      			if(recNum==words.length) ans.add(i);
      			recNum=0;
      			record.clear();     			
      		}
      	}
      	return ans;
    }
}