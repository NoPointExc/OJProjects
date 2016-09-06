import java.util.*;

public class Solution{

	//private static final int I=1,V=5,X=10,L=50, C=100,D=500,M=1000;		

	private static final HashMap<Character,Integer> MAP;
	static{
		char[] ch = {'I','V','X','L','C','D','M'};
		int[] num = {1,5,10,50,100,500,1000};
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<ch.length;i++){
			map.put(ch[i],num[i]);
		}
		MAP = map;
	}

	public int romanToInt(String s) {
		if(s.length()==0)
			return 0;
		int val = 0;
		char[] str = s.toCharArray();	
		int r=str.length-1;
		while(r>=0){
			if(r==0){
				val += MAP.get(str[r]);
				break;
			}else{
				int l = r-1;
				if(MAP.get(str[l])<MAP.get(str[r])){
					val += MAP.get(str[r])-MAP.get(str[l]);
					r-=2;
				}else{
					val += MAP.get(str[r]);
					r-=1;
				}
			}
		}

		return val;
	}

	public void sort(String[] names){
		NameComparator<String> comparator = new NameComparator<>();
		return Arrays.sort(names,comparator);
	}

	class NameComparator implements Comparator<String>{
		int compare(String name1, String name2){
			int rst = 0;
			String[] arr1 = name1.splite(" ");
			String[] arr2 = name2.splite(" ");
			if(Integer.valueOf(arr1[1])==Integer.valueOf(arr2(1)) ){
				//compare name
				int i = 0;
				String n1 = arr1[0];
				String n2 = arr2[0];
				while(i<n1.length() && i<n2.length() && n1.charAt(i) == n2.charAt(i)){
					i++;
				}

				if(i==n1.length()&&i==n2.length())
					return 0;
				if(i==n1.length())
					return -1;
				if(i==n2.length())
					return 1;
				return n1.charAt(i)-n2.charAt(i);
			}else{
				rst =Integer.valueOf(arr1[1]) - Integer.valueOf(arr2(1));  	
			}

			return rst;
		}
	}

	public static void main(String[] args){
		int len = Integer.parseInt(args[0]);
		String[] names = new String[len];
		for(int i=0;i<len;i++)
			names[i] = args[i+1];

		Solution solution = new Solution();
		String[] rst = solution.sort(names);

		for(String s:rst)
			System.out.println(s);
	}


}
