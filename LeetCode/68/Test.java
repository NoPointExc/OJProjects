class Test{
	//
//words: ["This", "is", "an", "example", "of", "text", "justification."]
	public static void main(String[] args) {
		if(args.length>1){
			int maxWidth=Integer.valueOf(args[args.length-1]);
			String[] words=args.subArray(args,0,args.length-1);
			Solution s=new Solution();
			List<String> rst=s.fullJustify(words,maxWidth);
			System.out.println(rst);
		}
	}
}