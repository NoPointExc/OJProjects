import java.io.*;
import java.util.*;
class Checker {
	String path = null;

	public Checker(String path) {
		this.path = path;
	}

//*******************query file, return attributes hashmap
	public Map<String, String> query(String path) throws FileNotFoundException, IOException {
		//query
		BufferedReader in = new BufferedReader(new FileReader(path));
		Map<String, String> attributes ;
		String line = "";
		StringBuilder sb = new StringBuilder();
		while (true) {
			String tmp = in.readLine();
			if (tmp == null) break;
			sb.append(tmp);
		}
		line = sb.toString();
		attributes = this.getAttributes(line.trim());
		return attributes;
	}

//******************get attribute hash map**********************
	public Map<String, String> getAttributes(String line) {
		Map<String, String> attributes = new HashMap<>();
		//remove
		line = line.substring(1, line.length() - 1); // warning!, out of range risk.
		System.out.println("#############getAttributes###########");
		String atts[] = line.split(",");
		//combine
		for (int j = 0; j < atts.length; j++) {
			if (atts[j].contains("{")) {
				StringBuilder tmpSb = new StringBuilder();
				int i = j;
				for (; i < atts.length && !atts[i].contains("}"); i++) {
					tmpSb.append(atts[i]);
					tmpSb.append(",");
					atts[i] = "";
				}
				atts[j] = tmpSb.append(atts[i]).toString();
				atts[i] = "";
			}
			//insert into hash map
			int cp = atts[j].indexOf(':'); //cut point
			if (cp != -1) {
				System.out.println("K=" + atts[j].substring(0, cp).trim() + ", V=" + atts[j].substring(cp + 1, atts[j].length()).trim());
				attributes.put(atts[j].substring(0, cp).trim(), atts[j].substring(cp + 1, atts[j].length()).trim());
			}
		}
		return attributes;
	}

//***************TOOL BOX ZONE*********************
//true: is long, false: is not long
//As V is Strings, so here provides a isLong to help U ensure wheter V can be parse into long.
	private boolean isLong(String s) {
		try {
			Long.parseLong(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

