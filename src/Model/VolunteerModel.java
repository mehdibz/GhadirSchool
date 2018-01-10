package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table( name = "VolunteerModel" )
//@TableGenerator(name = "seq", allocationSize = 110100, initialValue = 110100)
public class VolunteerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.IDENTITY, generator="seq")
	//@Column(name = "Std_ID", length = 11, precision = 110101, nullable = false)
	private int Userid;
	long Phone;
	private String Username,Fname,Lname,BirthDate,Email,Address,Gender,Password,PostalCode,City,
				   SubmittedDate,Resume,authority,farsi,religion,quran,salat,ReferenceName,ReferencePhone;

	

	
	public VolunteerModel(){ }
	
	
	
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		this.Userid = userid;
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

	public String getSubmittedDate() {
		return SubmittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.SubmittedDate = submittedDate;
	}

	
	//===================================================================================
	
	
	public String getResume() {
		return Resume;
	}

	public void setResume(String resume) {
		Resume = resume;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getFarsi() {
		return farsi;
	}

	public void setFarsi(String farsi) {
		this.farsi = farsi;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getQuran() {
		return quran;
	}

	public void setQuran(String quran) {
		this.quran = quran;
	}

	public String getSalat() {
		return salat;
	}

	public void setSalat(String salat) {
		this.salat = salat;
	}

	public String getReferenceName() {
		return ReferenceName;
	}

	public void setReferenceName(String referenceName) {
		ReferenceName = referenceName;
	}

	public String getReferencePhone() {
		return ReferencePhone;
	}

	public void setReferencePhone(String referencePhone) {
		ReferencePhone = referencePhone;
	}



}
