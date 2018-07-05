package Controller;

import javax.persistence.*;

import DB_Connection.DB_Connection;
import Model.StudentModel;

public class transaction {

	StudentModel std;
	EntityManagerFactory emf;
	EntityTransaction readTransaction,tx;
	EntityManager em;

	int UID;
	
	public StudentModel doRead(String userID) {
		emf = Persistence.createEntityManagerFactory("StudentLogin");
		em = emf.createEntityManager();
		readTransaction = em.getTransaction();

		readTransaction.begin();
		UID=Integer.parseInt(userID);
		std = em.find(StudentModel.class, UID);
		System.out.println("============="+UID);
		if(std!=null){
			readTransaction.commit();
			return std;
		}else{
			return null;
		}
	}
	
	
	public int doRegister(StudentModel std) {
		
		String query = null;	
//		query="insert into studentmodel values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		query="INSERT INTO studentmodel(Address, BirthDate, Carecard, City, DateTime, Details, Email, Emergency, FarsiGrade, Fname, Gender, Lname, Password, Phone, PostalCode, Restriction, Username) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int i = DB_Connection.StudentRegister(std,query);

		return i;
		}
	
	public boolean CheckExist(long CareCard) {
		
		String query = null;	
			
		query="SELECT COUNT(*) FROM studentmodel WHERE Carecard = '"+ Long.toString(CareCard)+"'";

			if(DB_Connection.DoubleID(query)){
				
				return true;
			}
			else{
				return false;
			}
		
		}
	
	public StudentModel Std_By_Scores(String userID) {
		emf = Persistence.createEntityManagerFactory("Std_By_Scores");
		em = emf.createEntityManager();
		readTransaction = em.getTransaction();

		readTransaction.begin();
		UID=Integer.parseInt(userID);
		std = em.find(StudentModel.class, UID);
		System.out.println("============="+UID);
		if(std!=null){
			readTransaction.commit();
			return std;
		}else{
			return null;
		}
		
	}
	
	
	
	public String Std_SavingScores(StudentModel std,Long Carecard) {
		
	emf = Persistence.createEntityManagerFactory("StudentCourses");
	em = emf.createEntityManager();
	tx = em.getTransaction();	
		
	Query query = em.createNativeQuery("SELECT COUNT(*) FROM StudentModel WHERE Std_ID = :id ");
	query.setParameter("id", Carecard);
	int res = Integer.parseInt(query.getSingleResult().toString());
	String result;
	
	if(res>0){
        try{
	    	 query = em.createNativeQuery("SELECT Std_ID FROM StudentModel WHERE Carecard = :id ");
	    	 query.setParameter("id", Carecard);
        	 result = "duplicate!@" + query.getSingleResult().toString();
          }
          catch (Exception e) {
             e.printStackTrace();
             result = "failed!";
          }
	}
	else{
	    	tx.begin();
		    em.persist(std);
		    em.flush();
		    em.clear();
		    tx.commit();
	       	result=String.format("Student ID: "+std.getId()+"@ Submitted Date: "+std.getDateTime() +  "\n Please save the student ID for future references");
		}
	return result;
	} 
}
	




/*

public String doRegister(StudentModel std,Long Carecard) {
	
	emf = Persistence.createEntityManagerFactory("StudentRegisterDB");
	em = emf.createEntityManager();
	tx = em.getTransaction();	
		
	Query query = em.createNativeQuery("SELECT COUNT(*) FROM StudentModel WHERE Carecard = :id ");
	query.setParameter("id", Carecard);
	int res = Integer.parseInt(query.getSingleResult().toString());
	String result;
	
	if(res>0){
        try{
	    	 query = em.createNativeQuery("SELECT Std_ID FROM StudentModel WHERE Carecard = :id ");
	    	 query.setParameter("id", Carecard);
        	 result = "duplicate!@" + query.getSingleResult().toString();
          }
          catch (Exception e) {
             e.printStackTrace();
             result = "failed!";
          }
	}
	else{
	    	tx.begin();
		    em.persist(std);
		    em.flush();
		    em.clear();
		    tx.commit();
	       	result=String.format("Student ID: "+std.getId()+"@ Submitted Date: "+std.getDateTime() +  "\n Please save the student ID for future references");
		}
	return result;
	}  */
