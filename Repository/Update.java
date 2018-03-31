import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Update {
	private String fileName;
	private String searchString;
	

	
	Update(String fileName,String searchString){
		this.fileName=fileName;
		this.searchString=searchString;
	}
	
	String newValue;
	String previousValue;
	
	public boolean update() {
		
		ArrayList<String[]> contact=new ArrayList<>();
		ReadfromFile ff=new ReadfromFile();
		int index=ff.getIndexInArrayList(fileName, searchString);
		
		if(index>=0) {
			//String newValue;
			String record[]=ff.getRecord(fileName, searchString);
			System.out.println("Updating record....");
			System.out.println(ArrayDisplay(record));
			
			
			try {
				//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter previous value");
				//previousValue=br.readLine();
				ConsoleStringInput in =new ConsoleStringInput();
				String previousValue=in.getConsole();
				System.out.println("Enter new value");
				//newValue=br.readLine();
				
				String newValue=in.getConsole();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		//add some question to the user to confirm here later :)
			
			contact=ff.getAllInArrayList(fileName);
			for(int i=0;i<contact.size();i++) {
				String[] tempRecord=contact.get(i);
				for(int j=0;j<tempRecord.length;j++) {
					if(tempRecord[j].equalsIgnoreCase(previousValue)) {
						tempRecord[j]=newValue;
						contact.set(i, tempRecord);
						System.out.println("Found");
						break;
					}
				}
			}
			try {
				FileWriter fw=new FileWriter(fileName,false);
				fw.write("");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			try {
				FileWriter fw=new FileWriter(fileName,true);
				for(String[] everything:contact) {
					String oneRecord=ArraytoString(everything);
					fw.append(oneRecord);
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			return true;
		}else {
			return false;
		}
	}
	
	public String ArraytoString(String[] stArr) {
		String toReturn="";
		int size=stArr.length;
		for(int i=0;i<size;i++) {
			if(i==size-1) {
				toReturn=toReturn+stArr[i]+"\n";
			}else {
				toReturn=toReturn+stArr[i]+",";
			}
		}
		
		return toReturn;
	}
	
	public String ArrayDisplay(String[] stArr) {
		String toReturn="";
		int size=stArr.length;
		for(int i=0;i<size;i++) {
				toReturn=toReturn+stArr[i]+"\n";
		}
		
		return toReturn;
	}

	
}
