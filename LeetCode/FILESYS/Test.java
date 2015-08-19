import java.io.*;
import java.util.*;

class Test{
	private static final String TAG="Test";
	public static void main(String[] args) {
		testQuery("fusedata.26");		
	}

//This is my test codes. It also shows you how to use query
	public static void testQuery(String path){
		Checker c=new Checker(path);
		try{
			
			Map<String, String> atts=c.query(path);
			Map<String, String> childAtt=c.getAttributes(atts.get("filename_to_inode_dict"));
			System.out.println(childAtt.get("d"));
		}catch(FileNotFoundException e ){
			System.out.println("FileNotFoundException");
		}catch(IOException e){
			System.out.println("IOException");
		}

	}




}