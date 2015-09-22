class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		int [][] in =new int[10][8];
		
		for(int i=0;i<in[0].length;i++)
			for(int j=0;j<in.length;j++) in[j][i]=5;
			
	
		in[8][0]=0;
		in[1][2]=0;
		in[4][4]=0;
		in[5][2]=0;


		for(int i=0;i<in[0].length;i++){
			for(int j=0;j<in.length;j++)					
					System.out.print(in[j][i]+",");					
				System.out.println();
		}

		s.setZeroes(in);

		System.out.println(">>>>>>>>>>>>>>>>>>>");
		for(int i=0;i<in[0].length;i++){
			for(int j=0;j<in.length;j++)					
					System.out.print(in[j][i]+",");					
				System.out.println();
		}

	}
}