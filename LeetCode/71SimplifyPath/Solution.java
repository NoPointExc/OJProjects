public class Solution {
    public String simplifyPath(String path) {
    	Path root=new Path("root");
    	Path pt=root;
    	int h=0, t=path.length();
    	String[] dirs=path.split("/");
    	for(String dir:dirs){
    		//.out.println(dir);
    		if(dir.length()==0||dir.equals(".")){
    			//System.out.println("euqals .");
    			continue;
    		}else if(dir.equals("..")){
    			if(!pt.isRoot()){
    				//System.out.println("euqals ..");
    				pt=pt.parent;
    				pt.child=null;
    			}
    		}else{
    			pt.mkdir(dir);
    			pt=pt.child;
    		}
    		//System.out.println("dir="+dir+" path="+root);
    	} 
    	if(root.child==null) return "/";   	
    	return root.child.toString();    
    }

    class Path{
    	Path child=null;
    	Path parent=null;
    	String name;
    	Path(String name){
    		this.name=name;
    	}
    	boolean isRoot(){
    		return parent==null;  
    	}
    	void mkdir(String dir){
    		child=new Path(dir);
    		child.parent=this;
    	}

    	//@Override
    	public String toString(){
    		Path pt=child;
    		StringBuilder sb=new StringBuilder("/"+name);
    		while(pt!=null){
    			sb.append("/");
    			sb.append(pt.name);
    			pt=pt.child;
    		}
    		return sb.toString();
    	}

    }
}