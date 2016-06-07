import java.util.*;

class Solution{
    public List<List<String>> ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Map<String,List<String>> reached = new HashMap<String,List<String>>();
        reached.put(beginWord,new LinkedList<String>());
        wordDict.add(endWord);
        int distance = 1;
        while(!reached.containsKey(endWord)) {
            Map<String,List<String>> toAdd = new HashMap<String,List<String>>();
            for(Map.Entry<String,List<String>> each: reached.entrySet()) {
                for (int i = 0; i < each.getKey().length(); i++) {
                    char[] chars = each.getKey().toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if(wordDict.contains(word)) {
                            List<String> list= each.getValue();
                            if(list.contains(word)) continue; //jump if already in the list
                            list.add(word);
                            toAdd.put(word,list);                            
                        }
                    }
                }
            }
            distance ++;
            if(toAdd.size() == 0) return new LinkedList<List<String>>();
            reached = toAdd;
        }
        //return final value
        List<List<String>> rst = new LinkedList<List<String>>();
        for(Map.Entry<String,List<String>> each:reached.entrySet()){
        	if(each.getKey().equals(endWord) && each.getValue().size() == distance){
        		rst.add(each.getValue());
        	}
        }

        return rst;
    }
}