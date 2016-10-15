public class Solution {
    
    private final static String FROM = "JFK";
    
    public List<String> findItinerary(String[][] tickets) {
        if(tickets == null){
            return null;
        }
        List<String> pthList = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String[] ticket : tickets){
            List<String> tmpLst = map.get(ticket[0]);
            if(tmpLst == null){
                tmpLst = new ArrayList<>();
            }
            tmpLst.add(ticket[1]);
            map.put(ticket[0], tmpLst);
        }
        pthList.add(FROM);
        dfs(FROM, map, pthList, tickets.length + 1);
        return pthList;
    }
    
    //true found one valid path
    private boolean dfs(String from, HashMap<String, List<String>> map, List<String> pthList, int pthLen){
        //System.out.println(from+ " list= "+ pthList);
        if(map == null || map.isEmpty() || !map.containsKey(from) ||map.get(from).isEmpty()){
            if(pthList.size() == pthLen){
                return true;
            }
            return false;
        }
        ArrayList<String> dstList = (ArrayList<String>)map.get(from);
        dstList.sort(String.CASE_INSENSITIVE_ORDER);
        for(int i = 0; i < dstList.size(); i++){
            String dst = dstList.get(i);
            pthList.add(dst);
            dstList.remove(i);
            map.put(from, dstList);
            if(dfs(dst, map, pthList, pthLen)){
                return true;
            }
            dstList.add(i, dst);
            pthList.remove(pthList.size() - 1);
            map.put(from, dstList);
        }
        return false;
    }
    
}