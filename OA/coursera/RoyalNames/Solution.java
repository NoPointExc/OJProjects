public class Solution{
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
	

	public void sort(String[] names){
		NameComparator<String> comparator = new NameComparator<>;
		return Arrays.sort(names,comparator);
	}

	class NameComparator implements Comparator<String>{
		int compare(String name1, String name2){
		}
	}
	
	public int parse(String name){
		int val = 0;
		int i=0;
		int len = name.length();
		//parse 10~50
		if(name.charAt(0)=='L'){
			val + =50;
			i++;
		}else if(name.charAt(0)== 'X'){
			if(name.length()>=2 && name.charAt(1)=='L'){
				val += 40;
				i+=2;
			}else{
				while(i<name.length() && name.charAt(i)=='X'){
					val +=10;
					i++;
				}
			}
		}

		//parse 0~9
		if(i<name.length()){
			if(len>=2 && name.charAt(len-1)=='X' && name.charAt(len-2)=='I'){
				val+=9;
			}else if(name.charAt(i)=='V'){
				i+=1;
				val +=5;
				while(i<name.length() && name.charAt(i)=='I'){
					val++;
					i++;
				}
			}else if(name.charAt(len-1)=='V'){
				val+=4;
			}else{
				while(i<name.length() && name.charAt(i)=='I'){
					i++;
					val++;
				}
			}
		}
		return val;
	}
}
