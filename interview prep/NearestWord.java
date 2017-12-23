import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class NearestWord {

	public static String nearestFreqWord(String text, String word, int n) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		Map<Integer,Integer> checkInd= new HashMap<Integer,Integer>();
		String text2 = text.replaceAll("\\W+"," ");
		String [] tokens = text2.split(" ");
		int i=0;
		int flag = 0;
		while(i<tokens.length) {
			if(word.equals(tokens[i])) {
			    	flag=1;
				for(int j=1;j<=n;j++) {
				    if(i-j >= 0 && !(checkInd.containsKey(i-j)) && !(tokens[i-j].equals(word))) {
				    	checkInd.put(i-j,0);
					if(map.containsKey(tokens[i-j]))
						map.replace(tokens[i-j],map.get(tokens[i-j])+1);
					else
						map.put(tokens[i-j],1);
					}
				    if(i+j < tokens.length && !(checkInd.containsKey(i+j)) && !(tokens[i+j].equals(word))) {
				    	checkInd.put(i+j,0);
				      if(!word.equals(tokens[i+j]))	{
						if(map.containsKey(tokens[i+j]))
							map.replace(tokens[i+j],map.get(tokens[i+j])+1);
						else
							map.put(tokens[i+j],1);
				    }	
					}
				}
				i+=n;
			}	
			else
				i++;
		}
		String returnString ="N/A";
		if(flag==1){
		  Iterator it = map.entrySet().iterator();
		  Map.Entry mentry = (Map.Entry)it.next();
		  int max = (Integer) mentry.getValue();
		  returnString = (String) mentry.getKey();
		  while(it.hasNext()) {
		  	    mentry = (Map.Entry)it.next();
		  		if(max < (Integer) mentry.getValue()) {
		  			returnString = (String) mentry.getKey();
		  			max = (Integer) mentry.getValue();
		  		}
		  }
		}
		return returnString;
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String text = sc.nextLine();
    	String word = sc.nextLine();
    	int n  = Integer.parseInt(sc.nextLine());
    	System.out.println(NearestWord.nearestFreqWord(text.toLowerCase(), word.toLowerCase(), n));
        
    }
}