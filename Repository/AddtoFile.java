import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddtoFile  {
	public boolean addAll(PhoneBook pb,String fileName) {
		File file=new File(fileName); //Create file
		try {
			FileWriter fw=new FileWriter(file,true); //opening file
			//fw.write(pb.toString()); //writing to a file 
			fw.append(pb.toString());
			fw.append("\n");
			fw.close(); //closing a file
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}	
	}
}
