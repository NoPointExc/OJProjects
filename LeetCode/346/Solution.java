public class MovingAverage {
    private int maxSize;
    LinkedList<Integer> queue;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
	maxSize = size;
	queue = new LinkedList<>();
    }

    public double next(int val) {
	queue.offer(val);
	if(queue.size() > maxSize){
	    sum -= queue.poll();
	}
	sum += val;

	return ((double)sum) / ((double) queue.size()); 
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
