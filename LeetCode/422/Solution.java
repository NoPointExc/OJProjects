public class Solution {
    public boolean validWordSquare(List<String> words) {
	if(words == null){
	    return false;
	}
	String[] arr = new String[words.size()];
	int col = 0;
	for(String word : words){
	    arr[col] = word;
	    col++;
	}

	for(int c = 0; c < arr.length; c++){
	    for(int r =0; r < arr[c].length(); r++){
		if(r >= arr.length || c>= arr[r].length() || arr[r].charAt(c) != arr[c].charAt(r)){
		    return false;
		}
	    }
	}

	return true;
    }
}
