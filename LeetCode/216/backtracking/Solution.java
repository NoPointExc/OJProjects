public class Solution {
    HashMap<Pair,List<List<Integer>>> cache = new HashMap <Pair,List<List<Integer>>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        Pair pair = new Pair(k,n);
        List<List<Integer>> rst = cache.get(pair);
        if(rst!=null)
            return rst;
        else
            rst=new LinkedList<List<Integer>>();

        if(k>n) 
            return rst;

        if(k==1){
            if(n<10){ 
                List<Integer> tmp = new LinkedList<Integer>();
                tmp.add(n);
                rst.add(tmp);
            }
        }else{
            
            for(int i=k;n-i<k && i<10;i++){
                List<List<Integer>> lastRst=combinationSum3(k-1,n-i);
                for(List<Integer> l:lastRst){
                    if(l.get(0)<i){ 
                        List<Integer> tmp=new ArrayList<Integer> (l);
                        tmp.add(0,i);
                        rst.add(tmp);
                    }
                }
            }
        }

        cache.put(pair,rst);
        return rst;
    }

    class Pair{
        int k=-1;
        int n=-1;
        public Pair(int k,int n){
            this.k=k;
            this.n=n;
        }
    }
}
