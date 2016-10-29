public class Solution {
    public List<List<String>> wordSquares(String[] words) {
	if(words == null){
	    return null;
	}
	List<List<String>> rstList = new LinkedList<>();
	Tire root = new Tire();
	for(String word : words){
	    root.add(word);
	}

	for(String word : words){
	    String[] map = new String[words.length];
	    map[0] = word;
	    backTracking(1, map, root, rstList);
	}

	return rstList;
    }

    void backTracking(int next, String[] map, Tire root, List<List<String>> rstList){
	if(next == map.length){
	    List<String> tmpList = new LinkedList<>();
	    for(String word : map){
		tmpList.add(word);
	    }
	    rstList.add(tmpList);
	}else{
	    String prf = "";
	    for(int i = 0; i < next; i++){
		prf += map[i].charAt(next);
	    }
	    Tire tire = root;
	    char[] arr = prf.toCharArray();
	    for(char c : arr){
		tire = tire.nexts[c - 'a'];
		if(tire == null){
		    return;
		}
	    }
	    //search all possible wrod under this tire
	    List<String> words = tire.getAll();
	    for(String word : words){
		map[next] = word;
		backTracking(next + 1, map, root, rstList);
	    }
	}    
    }

    class Tire{
	String val;
	Tire[] nexts;

	Tire(){
	    val = null;
	    nexts = new Tire[26];
	}

	void add(String word){
	    if(word == null || word.length() == 0){
		val = word;
	    }else{
		char[] arr = word.toCharArray();
		Tire cur = this;
		for(char c : arr){
		    cur = cur.nexts[c - 'a'];
		    if(cur == null){
			cur = new Tire();
		    }
		}
		cur.val = word;
	    }
	}

	//dfs
	List<String> getAll(){
	    List<String> rstList = new LinkedList<>();
	    LinkedList<Tire> stack = new LinkedList<>();
	    Tire cur = this;
	    while(cur != null || !stack.isEmpty()){
		if(cur == null){
		    cur = stack.pop();
		}else{
		    if(cur.val != null){
			rstList.add(cur.val);
		    }
		    for(Tire tire : cur.nexts){
			if(tire != null){
			    stack.push(tire);             
			}
		    }
		}
	    }

	    return rstList;
	}

    }


}
