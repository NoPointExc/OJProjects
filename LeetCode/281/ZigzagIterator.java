import java.util.*;

public class ZigzagIterator {
    Iterator<Integer> it1;
    Iterator<Integer> it2;
    int turns;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	this.it1 = v1.iterator();
	this.it2 = v2.iterator();
	turns = 0;
    }

    public int next(){
	int rst = -1;
	
	if(turns ==0 && it1.hasNext()){
	    rst = it1.next();
	}else if( it2.hasNext() ){
	    rst = it2.next();
	}else{
	    //should throws a exception here
	    rst = -1;
	}

	turns = 1 - turns;
	return rst;
    }

    public boolean hasNext(){
	return it1.hasNext() || it2.hasNext();
    }

    public static void main(String[] args){
	List<Integer> it1 = new ArrayList<>();
	List<Integer> it2 = new ArrayList<>();
	
	//for(int i=0;i<10;i++){
	//    it1.add(2*i);
	//    it2.add(2*i+1);
	//}
	
	it2.add(100);
	it2.add(10000);

	ZigzagIterator  zig = new ZigzagIterator(it1,it2);
	
	while( zig.hasNext() ){
	    System.out.print(zig.next()+" ");
	}
	System.out.println();
    }
}
