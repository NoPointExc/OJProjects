import java.util.*;

class Test{
	public static void main(String[] args){
		Solution s=new Solution();
		int [] text={4,5,4,5,4,5,6,3,4,5,6,7,5,5,4};
		int [] word={4,5,6,7};
		System.out.println("text="+Arrays.toString(text));
		System.out.println("word="+Arrays.toString(word));
		boolean rst=s.find(text,word);
		System.out.println("rst="+rst);
	}
}
