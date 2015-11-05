import java.util.*;
public class Test{
	public static void main(String[] args) {
		if(args.length>0){
			Solution s=new Solution();
			List<Integer> rst=s.grayCode(Integer.valueOf(args[0]));
			System.out.println("rst="+rst);
		}
	}
}