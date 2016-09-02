class Test{
	public static void main(String[] args){
		LRUCache lru = new LRUCache(2);
		lru.set(2,1);
		System.out.println(lru.queue);
		lru.set(2,2);
		System.out.println(lru.queue);
		System.out.println(lru.get(2));
		System.out.println(lru.queue);
		lru.set(1,1);
		System.out.println(lru.queue);
		lru.set(4,1);
		System.out.println(lru.queue);
		System.out.println(lru.get(2));
		System.out.println(lru.queue);

	}
}
