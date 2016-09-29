public class Solution {
	
	private final String[] LESS_THAN_20 
	= {"", "One", "Two", "Three", "Four", "Five",
 	"Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
 	 "Twelve", "Thirteen", "Fourteen", "Fifteen", 
 	 "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

	private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	private final String[] THOUSANDS = {"","Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
    	if( num ==0 )
    		return "Zero";

        if( num < 20){
        	return LESS_THAN_20[num];
        }else if(num <= 99){        	
       		return (TENS[num / 10] + " " + LESS_THAN_20[num % 10]).trim();
        }else if(num <= 999){
        	if(num % 100 == 0)
        		return numberToWords(num / 100) + " " + "Hundred";
        	else
        		return numberToWords(num / 100) + " " + "Hundred" + " " +numberToWords(num % 100);
        }else{
        	long base = 1L;
        	
        	for(int i=1; i<=THOUSANDS.length; i++){
        		base *= 1000L;
        		if((long)num / base < 1000L){
        			if(num % (int)base == 0)
        				return numberToWords(num / (int)base) + " " + THOUSANDS[i];
        			else
        				return numberToWords(num / (int)base) + " " + THOUSANDS[i] + " " + numberToWords(num % (int)base);
        		}
        	}        	
        	
        }

        return "";
    }

    public static void main(String[] args){
    	Solution s = new Solution();
    	if(args.length == 0 )
    		return;
    	String rst = s.numberToWords( Integer.parseInt(args[0]) );
    	System.out.println( rst);
    }

}