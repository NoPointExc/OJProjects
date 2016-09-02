import java.util.*;

public class LRUCache {
	public  LinkedList<Integer> queue;
	private HashMap<Integer,Value> map;

	private final int capacity;
	private int usableCapacity;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		usableCapacity = capacity;
		queue = new LinkedList<Integer>();
		map = new HashMap<Integer,Value>();
	}

	public int get(int key) {
		int val = -1;
		if(map.containsKey(key)){
			Value value = map.get(key);
			val = value.value;
			value.dirtyNum +=1;
			queue.offer(key);
		}
		return val;
	}

	public void set(int key, int value) {
		if(map.containsKey(key)){
			update(key,value);
		}else{
			ensure();
			Value v= new Value(value);
			usableCapacity --;
			queue.offer(key);
			map.put(key,v);
		}
		
	}

	private void update(int key,int value){
		Value v = map.get(key);
		if(v.value!=value){
			v.value = value;
			v.dirtyNum +=1;
			queue.offer(key);
		}
	}

	//ensure at least one empty space
	private void ensure(){
		while(usableCapacity<=0){
			int invalidateKey = queue.poll();
			Value invalidateVal = map.get(invalidateKey);
			if(invalidateVal==null || invalidateVal.dirtyNum == 0){
				map.remove(invalidateKey);
				usableCapacity ++;
			}else{
				invalidateVal.dirtyNum -=1;
				map.put(invalidateKey,invalidateVal);
			}

		}	
	}

	class Value{
		int value;
		int dirtyNum;
		public Value(int value){
			this.value = value;
			dirtyNum = 0;
		}
	}
}
