import java.util.*;

public class ValidWordAbbr {
    HashMap<String,HashSet<String>> dict;

    public ValidWordAbbr(String[] dictionary) {
    	dict = new HashMap<>();
	for(String word:dictionary){
	    String abbr = getAbbr(word);
	    if(dict.containsKey(abbr)){
		HashSet<String> words = dict.get(abbr); 
		words.add(word);
	    }else{
		HashSet<String> words = new HashSet<>();
		words.add(word);
		dict.put(abbr,words);
	    }
	}
    }

    private String getAbbr(String str){
	int len = str.length();
	if(len<=2)
	    return str;
	return str.charAt(0)+String.valueOf(len-2)+str.charAt(len-1);	
    }

    public boolean isUnique(String word) {
	String abbr = getAbbr(word);
	HashSet<String> words = dict.get(abbr);
	if(words == null)
	    return true;
	
	return words.size()== 1 && words.contains(word);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
