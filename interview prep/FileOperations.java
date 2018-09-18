import java.util.*;
import java.io.*;

class FileOperations {
	public static void main(String[] args) throws IOException {
		String file="xyz.txt";
		File filename = new File(file);
		Scanner sc = new Scanner(filename);
		Map<String,Integer> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens =line.split(" ");
            if(map.containsKey(tokens[0])){
            	map.put(tokens[0],map.get(tokens[0])+1);
            }
            else map.put(tokens[0],1);
         }
          BufferedWriter out = new BufferedWriter(new FileWriter("records_"+filename));
         for (Map.Entry<String,Integer> entry : map.entrySet()) {
   			 out.write(entry.getKey()+" "+entry.getValue());
   			 out.newLine();
		}
		out.close();

	}
}