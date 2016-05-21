import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        if(beginWord.length()==1) return 2;
        int len=wordList.size();
        LinkedList<String> from=new LinkedList<String> ();
        from.add(beginWord);
        LinkedList<String> to=new LinkedList<String>();
        int step=1;
        int oneMore=2;
        while(oneMore>0){
        		if(from.isEmpty()) oneMore--;
        		step++;
                for(String begin:from){                    
                    System.out.println("[before]step="+step+" begin="+begin+" from="+from+" wordList"+wordList);
                    if(isOneStep(begin,endWord)) return step;
                    Iterator<String> it=wordList.iterator();
                    while(it.hasNext()){
                        String word=it.next();
                        if(word.equals(begin)||word.equals(endWord)){
                            it.remove();
                        }else if(isOneStep(begin,word)){
                            to.add(word);
                            it.remove();
                        }   
                    }
         
	            }
				from=to;
				to=new LinkedList<String>();   
        }

        return 0;
    }
    
    private boolean isOneStep(String from, String to){
        int ct=0;
        int len=from.length();
        for(int i=0;i<len;i++){
            if(from.charAt(i)!=to.charAt(i)) {
                ct++;
            }
        }
        return ct==1;
    }
}