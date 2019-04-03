import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class WordCount {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		String line;
		
		while((line = br.readLine()) != null){
			String words[] = line.split(" ");
			for(String word : words){
				Integer count = table.get(word);
				if(count == null)
					count = 0;
				table.put(word, count+1);
			}
		}
		br.close();
		
		for(java.util.Map.Entry<String, Integer> e : table.entrySet()){
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
	
}
