import java.util.*;

public class Solution {
    
    public List<String> generateAbbreviations(String word) {
	List<String> abbers = new ArrayList<>();
	if(word.length()==0){
	    abbers.add(word);
	    return abbers;
	}
	int num = 2<<word.length()-1;
	
	while(num!=0){
	    int bits = num;
	    char[] abber = word.toCharArray();
	    
	    for(int i=abber.length-1;i>=0 && bits!=0;i--){
		if(bits%2==1){
		    abber[i] = '*';
		}
		bits >>= 1;
	    }

	    int count = 0;
	    StringBuilder sb = new StringBuilder();

	    for(int i=0;i<abber.length;i++){
		if(abber[i]=='*'){
		    count++;	
		}else{
		    if(count!=0){
			sb.append(count);
			count = 0;
		    }
		    sb.append(abber[i]);
		}
	    }
	    if(count!=0)
		sb.append(count);
	    num--;
	    abbers.add(sb.toString());
	}
	
	return abbers;
    }

    public static void main(String[] args){
	if(args.length==0)
	    return;

	Solution s = new Solution();
	List<String> rst = s.generateAbbreviations(args[0]);
	System.out.println(rst);
    }

}
