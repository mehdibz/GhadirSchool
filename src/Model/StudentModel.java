package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table( name = "StudentModel" )
@TableGenerator(name = "seq", allocationSize = 110100, initialValue = 110100)
//@SequenceGenerator(name="seq", initialValue=110101, allocationSize=110100)
public class StudentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	//@Column(name = "Std_ID", length = 11, precision = 110101, nullable = false)
	private int Std_ID;
	private String Username,Fname,Lname,BirthDate,Email,Address,Restriction,Details,Gender,Password,PostalCode,City,DateTime;
	long Phone,Emergency,Carecard;
	int FarsiGrade;
	
	public StudentModel(){ }
	


	
	
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getId() {
		return Std_ID;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getRestriction() {
		return Restriction;
	}

	public void setRestriction(String restriction) {
		Restriction = restriction;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long phone) {
		Phone = phone;
	}

	public long getEmergency() {
		return Emergency;
	}

	public void setEmergency(long emergency) {
		Emergency = emergency;
	}

	public long getCarecard() {
		return Carecard;
	}

	public void setCarecard(long carecard) {
		Carecard = carecard;
	}

	public String getPostalCode() {
		return PostalCode;
	}
	
	public void setPostalCode(String postalcode) {
		PostalCode = postalcode;
	}
	
	public String getCity() {
		return City;
	}
	
	public void setCity(String city) {
		City = city;
	}
	public long getFarsiGrade() {
		return FarsiGrade;
	}
	
	public void setFarsiGrade(int farsigrade) {
		FarsiGrade = farsigrade;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
}
