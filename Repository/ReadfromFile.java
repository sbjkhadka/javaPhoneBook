import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;



public class ReadfromFile {
	
	public ArrayList<String[]> getAllInArrayList(String filename){
		ArrayList<String[]> contact=new ArrayList<>();
		String record;
		File file=new File(filename); //create a file
		//opening a file
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			while((record=br.readLine())!=null) {
				String[] splitRecord=record.split(",");
				contact.add(splitRecord);
				//br.close();
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
	}
	
	public int getIndexInArrayList(String fileName,String searchString) {
		ArrayList<String[]> allData=new ArrayList<>();
		allData=getAllInArrayList(fileName);
		for(String[] record:allData) {
			for(String data:record) {
				if(data.equalsIgnoreCase(searchString)) {
					return allData.indexOf(record);
				}
			}	
		}
		return -1;
	}
	
	public String[] getRecord(String fileName,String searchString) {
		ArrayList<String[]> allData=new ArrayList<>();
		String[] toReturn= {};
		allData=getAllInArrayList(fileName);
		for(String[] record:allData) {
			for(String data:record) {
				if(data.equalsIgnoreCase(searchString)) {
					return record;
				}
			}	
		}
		return toReturn;
	}
}
