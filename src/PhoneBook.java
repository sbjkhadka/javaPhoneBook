import java.util.ArrayList;


public class PhoneBook {
	private String firstName;
	private String lastName;
	private String email;
	private String homePhone;
	private String mobileNumber;
	private String streetNumber;
	private String postalCode;
	private String city;
	private String province;
	private String country;
	private String fileName="C:\\JavaPrac\\myfile.csv";
	
	PhoneBook(String firstName,String lastName,String email,String homePhone,
			String mobileNumber,String streetNumber,String postalCode,String city,String province,String country){
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.homePhone=homePhone;
		this.mobileNumber=mobileNumber;
		this.streetNumber=streetNumber;
		this.postalCode=postalCode;
		this.city=city;
		this.province=province;
		this.country=country;
	}
	PhoneBook(){
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public String toString() {
		return this.firstName+","+this.lastName+","+this.email+","+this.homePhone+","+
				this.mobileNumber+","+this.streetNumber+","
				+this.postalCode+","+this.city+","+this.province+","
				+this.country;
	}
	public void addNewRecord(PhoneBook phone_book) {
		boolean response;
		AddtoFile objAdd=new AddtoFile();
		
		response=objAdd.addAll(phone_book, fileName);
		if(response) {
			System.out.println("Success: Record Added!!!");
			//return "Success: Record Added!!!";
		}else {
			System.out.println("Failed: Unable to add record!");
			//return "Failed: Unable to add record!";
		}
		
	}
	
	public void getRecords() {
		String record= "";
		System.out.println("Enter your search keyword\t");
		ConsoleStringInput in=new ConsoleStringInput();
		String searchString=in.getConsole();
		ArrayList<String[]> fromFile=new ArrayList<>();
		ArrayList<String> found=new ArrayList<>();
		ReadfromFile objRead=new ReadfromFile();
		fromFile=objRead.getAllInArrayList(fileName);
		for(String[] oneRecord:fromFile) {
			for(String data:oneRecord) {
				if(data.equalsIgnoreCase(searchString)) {
					record= "First Name: "+oneRecord[0]+"\n"+
							"Last Name: "+oneRecord[1]+"\n"+
							"Email: "+oneRecord[2]+"\n"+
							"Home Phone: "+oneRecord[3]+"\n"+
							"Mobile Number: "+oneRecord[4]+"\n"+
							"Street: "+oneRecord[5]+"\n"+
							"Postal Code: "+oneRecord[6]+"\n"+
							"City: "+oneRecord[7]+"\n"+
							"Province: "+oneRecord[8]+"\n"+
							"Country: "+oneRecord[9]+"\n";
					found.add(record);
				}
			}
		}
		int s=found.size();
		System.out.println("Found "+s+" results");
		for(int i=0;i<s;i++) {
			System.out.println("Record Number"+(i+1)+"\n");
			System.out.println(found.get(i));
		}
	}
	
	
	public void deleteRecords() {
		ArrayList<String[]> fromFile=new ArrayList<>();
		ReadfromFile objRead=new ReadfromFile();
		fromFile=objRead.getAllInArrayList(fileName);
		System.out.println("Choose any record....");
		for(String[] all:fromFile) {
			System.out.println(all[0]+" "+all[1]);
		}
		System.out.println("Enter any record to delete...");
		ConsoleStringInput in=new ConsoleStringInput();
		String searchString=in.getConsole();
		Delete d=new Delete(fileName, searchString);
		if(d.delete()) {
			System.out.println("Success: One record deleted!");
		}else {
			System.out.println("Fail: Could not delete record");
		}
	}
	
	public void updateRecords() {
		System.out.println("Enter any record to update...");
		ConsoleStringInput in=new ConsoleStringInput();
		String searchString=in.getConsole();
		Update upd=new Update(fileName, searchString);
		if(upd.update()) {
			System.out.println("Success: One record updated successfully");
		}else {
			System.out.println("Error: Could not update record!");
		}
	}
	
	
	
	
	

}
