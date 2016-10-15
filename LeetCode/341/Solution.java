/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private final LinkedList<ListIterator<NestedInteger>> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        removeEmptyIterator();
        NestedInteger nextNested = stack.peek().next();
        
        while(!nextNested.isInteger()){
            stack.push(nextNested.getList().listIterator());
            nextNested = stack.peek().next();
        }
        
        return nextNested.getInteger();
    }

    @Override
    public boolean hasNext() {
        removeEmptyIterator();
        if(stack.isEmpty()){
            return false;
        }
        
        return true;
    }
    
    private void removeEmptyIterator(){
        while(!stack.isEmpty()){
            if(!stack.peek().hasNext()){
                stack.pop();
            }else{
                NestedInteger nextNested = stack.peek().next();
                if(nextNested.isInteger()){
                    stack.peek().previous();
                    break;
                }else{
                    stack.push(nextNested.getList().listIterator());
                }
            }
        }
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */