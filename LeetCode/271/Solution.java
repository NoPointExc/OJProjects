public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null){
            return null;
        }
        StringBuilder headBuilder = new StringBuilder();
        StringBuilder textBuilder = new StringBuilder();
        headBuilder.append(strs.size() + ";");
        for(String str : strs){
            headBuilder.append(str.length() + ";");
            textBuilder.append(str);
        }
        headBuilder.append("$");
        headBuilder.append(textBuilder.toString());
        return headBuilder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s == null){
            return null;
        }
        int headLen = s.indexOf('$');
        String[] headStrs = s.substring(0, headLen).split(";");
        int[] headVal = new int[headStrs.length];
        
        for(int i = 0; i < headVal.length; i++){
            headVal[i] = Integer.parseInt(headStrs[i]);
        }
        
        ArrayList<String> rstList = new ArrayList<>(headVal[0]);
        int begin = headLen + 1;
        
        for(int i = 1; i < headVal.length; i++){
            String tmp = s.substring(begin, begin + headVal[i]);
            rstList.add(tmp);
            begin = begin + headVal[i];
        }
        
        return rstList;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));