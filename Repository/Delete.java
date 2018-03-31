import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Delete {
	private String fileName;
	private String searchString;
	ArrayList<String[]> contact=new ArrayList<>();
	Delete(String fileName,String searchString){
		this.fileName=fileName;
		this.searchString=searchString;
	}
	ReadfromFile ff=new ReadfromFile();
	
	
	
	public boolean delete()  {
		
		int index=ff.getIndexInArrayList(fileName, searchString);
		if(index>=0) {
			contact=ff.getAllInArrayList(fileName);
			contact.remove(index);
			
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
		}
		else {
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
	}
	
	
	


