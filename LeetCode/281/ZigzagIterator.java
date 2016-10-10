public class ZigzagIterator {
    int count1 = 0, count2 = 0;
    List<Integer> v1, v2;
    Iterator<Integer> it1, it2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        it1 = v1 != null ? v1.iterator() : null;
        it2 = v2 != null ? v2.iterator() : null;
    }

    public int next() {
        if(v1 == null || count1 == v1.size()){
            count2++;
            return it2.next();
        }
        if(v2 == null || count2 == v2.size()){
            count1++;
            return it1.next();
        }
        if(count1 <= count2){
            count1++;
            return it1.next();
        }
        count2++;
        return it2.next();   
    }

    public boolean hasNext() {
        return (count1 + count2) < (v1.size() + v2.size()); 
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */