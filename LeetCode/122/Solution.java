public class Solution {
    int[] prices;
        public int maxProfit(int[] prices) {
	        int len=prices.length;
		        int[][] prof=new int[len][len];
			        if(len==0) return 0;
				        for(int i=0;i<len;i++){
					            for(int j=0;j<len;j++){
						                    if(j>=i){
								                        prof[i][j]=0;
											                }else{
													                    prof[i][j]=prices[j]-prices[i];
															                    }
																	                }
																			        }
																				        
																					        for(int i=1;i<len;i++){
																						            prof[i][0]=prof[i][0]>prof[i-1][0]?prof[i][0]:prof[i-1][0];
																							                for(int j=1;j<i;j++){
																									                int tmp=prof[i-1][j-1]>prof[i-1][j]?prof[i-1][j-1]:prof[i-1][j];
																											                prof[i][j]=tmp>prof[i][j]?tmp:prof[i][j];
																													            }
																														            }
																															            
																																            int max=prof[len-1][0];
																																	            for(int i=1;i<len;i++){
																																		                max=prof[len-1][i]>max?prof[len-1][i]:max;
																																				        }
																																					        return max;
																																						    }
																																						    }
