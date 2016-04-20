import java.io.BufferedReader;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
/** 
 *  
 * @author anuj.mehta 
 * 
 */  
public class AlienLanguage {  
  
 public static void main(String[] args) {  
 try {  
   BufferedReader br = new BufferedReader(new FileReader("A-small-practice.in"));  
   String[] arr = br.readLine().split(" ");  
   int numOfWords = Integer.parseInt(arr[1]);  
   int numOfPatterns = Integer.parseInt(arr[2]);  
     
   ArrayList<String> wordList = new ArrayList<String>();  
   for(int i =0; i < numOfWords; i++)  
    wordList.add(br.readLine());  
     
   ArrayList<Pattern> patternList = new ArrayList<Pattern>();  
   for(int i =0; i < numOfPatterns; i++)  
    patternList.add(Pattern.compile( br.readLine().replace('(', '[').replace(')', ']')));  
   int index = 0;  
   for(Pattern p : patternList)  
   {  
    index++;  
    int count = 0;  
    for(String word : wordList)  
    {  
     Matcher m = p.matcher(word);  
     if(m.matches())  
      count++;  
    }  
    System.out.println("Case " + index + ": " + count);  
   }  
  } catch (FileNotFoundException e) {  
   e.printStackTrace();  
  } catch (IOException e) {  
   e.printStackTrace();  
  }  
 }  
}  