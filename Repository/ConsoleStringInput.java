import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleStringInput {
	public  String getConsole() {
		String value="Error";
		
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			value= br.readLine();
			//br.close();
			return value;
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error: Unable to fetch string from Keyboard.");
			
			return value;
		}
		
		
	}

}
