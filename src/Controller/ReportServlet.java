package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ReportModel;
import Model.StudentModel;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tutorial.util.HibernateUtil;
import org.hibernate.Query;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/ReportServlet")

public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 String checkUser,Header,Footer,Send,Loginmsg,TxArea,F_description,R_description,Q_description,S_description,hidden,Currentuser,send;
	 String std_id,std_id2,std_name,std_family,course_name,dictation_score,grammar_score,reading_score,discipline_score,tot_score;
	 String FarsiRec,ReligionRec,QuranRec,SalatRec,LastFarsi,LastReligion,LastQuran,LastSalat,FDate,FClass,FClass2,uname,password;
	 Query query1,query2,query3,query4;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		

		 std_id=request.getParameter("userid");
		 std_id2=request.getParameter("userid2");
		 FDate=request.getParameter("ForDate");
		 FClass=request.getParameter("ForClass");
		 FClass2=request.getParameter("ForClass2");
		
	     
	                Session session = null;

	                SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	                session = sessionFactory.openSession();
	                org.hibernate.Transaction tx = session.beginTransaction();

	                String Q = " from ReportModel where Student_ID= :id ";
	                String St = " from StudentModel where Id= :id ";
	                
	                query1 = session.createQuery(Q);
	                query2 = session.createQuery(St);
	                
	                query1.setParameter("id", std_id);
	                query2.setParameter("id", std_id);

	                List<?> RepoProfile = query1.list();
	                List<?> StdProfile = query2.list();

	                if(std_id!=null){
	                for (int i = 0; i < RepoProfile.size(); i++) {
	                	ReportModel Rm = (ReportModel) RepoProfile.get(i);
	                	StudentModel Sm = (StudentModel) StdProfile.get(i);
	                	
	  	                request.setAttribute("userid",Sm.getUserid());
	  	                request.setAttribute("ForDate",FDate);
	  	                request.setAttribute("ForClass",FClass);
	  	                request.setAttribute("stdNameFamily",Sm.getFname()+" "+Sm.getLname());
	  	                request.setAttribute("Farsi",Rm.getFarsi_score());
	  	                request.setAttribute("Dictation",Rm.getDictation_score());
	  	                request.setAttribute("Grammar",Rm.getGrammar_score());
	  	                request.setAttribute("Reading",Rm.getReading_score());
	  	                request.setAttribute("FarsiDis",Rm.getFaDisciplineScore());
	  	                request.setAttribute("FarsiDetails",Rm.getF_description());
	  	                request.setAttribute("Religion",Rm.getReligion_score());
	  	                request.setAttribute("ReligionDis",Rm.getReDisciplineScore());
	  	                request.setAttribute("ReligionDetails",Rm.getR_description());
	  	                request.setAttribute("Quran",Rm.getQuran_score());
	  	                request.setAttribute("QuranDis",Rm.getQuDisciplineScore());
	  	                request.setAttribute("QuranDetails",Rm.getQ_description());
	  	                request.setAttribute("Salat",Rm.getSalat_score());
	  	                request.setAttribute("SalatDis",Rm.getSaDisciplineScore());
	  	                request.setAttribute("SalatDetails",Rm.getS_description());
	  	                request.setAttribute("TotalDis",Rm.getDiscipline_score());
	                	}
	                }
                
 	                query1.setParameter("id", std_id2);
	                query2.setParameter("id", std_id2);

	                RepoProfile = query1.list();
	                StdProfile = query2.list();
	                if(std_id2!=null){
	                for (int i = 0; i < RepoProfile.size(); i++) {
	                	ReportModel Rm2 = (ReportModel) RepoProfile.get(i);
	                	StudentModel Sm2 = (StudentModel) StdProfile.get(i);
	                	
	                	request.setAttribute("userid2",Sm2.getUserid());
	                	request.setAttribute("ForDate2",FDate);
	                	request.setAttribute("ForClass2",FClass2);
	                	request.setAttribute("stdNameFamily2",Sm2.getFname()+" "+Sm2.getLname());
	                	request.setAttribute("Farsi2",Rm2.getFarsi_score());
	                	request.setAttribute("Dictation2",Rm2.getDictation_score());
	                	request.setAttribute("Grammar2",Rm2.getGrammar_score());
	                	request.setAttribute("Reading2",Rm2.getReading_score());
	                	request.setAttribute("FarsiDis2",Rm2.getFaDisciplineScore());
	                	request.setAttribute("FarsiDetails2",Rm2.getF_description());
	                	request.setAttribute("Religion2",Rm2.getReligion_score());
	                	request.setAttribute("ReligionDis2",Rm2.getReDisciplineScore());
	                	request.setAttribute("ReligionDetails2",Rm2.getR_description());
	                	request.setAttribute("Quran2",Rm2.getQuran_score());
	                	request.setAttribute("QuranDis2",Rm2.getQuDisciplineScore());
	                	request.setAttribute("QuranDetails2",Rm2.getQ_description());
	                	request.setAttribute("Salat2",Rm2.getSalat_score());
	                	request.setAttribute("SalatDis2",Rm2.getSaDisciplineScore());
	                	request.setAttribute("SalatDetails2",Rm2.getS_description());
	                	request.setAttribute("TotalDis2",Rm2.getDiscipline_score());
	                	}
	                }
	                HibernateUtil.getSessionFactory().close();
	                
	                tx.commit();
	                session.flush();
	               // session.close();

	                
			    	request.getRequestDispatcher("ReportForm.jsp").forward(request, response);
	                response.sendRedirect("ReportForm.jsp");

	}
}









/*


package org.hibernate.tutorial;

 
public class EventManager {
 
    public static void main(String[] args) {
        EventManager mgr = new EventManager();
 
        mgr.createAndStoreEvent("My First Event", new Date());
 
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2012); // Year
        calendar.set(Calendar.MONTH, 0);   // Month, The first month of the year is JANUARY which is 0
        calendar.set(Calendar.DATE, 1);    // Day, The first day of the month has value 1.
        mgr.createAndStoreEvent("My Second Event", calendar.getTime());
 
        List events = mgr.listEvents();
        for (int i = 0; i < events.size(); i++) {
            Event theEvent = (Event) events.get(i);
            System.out.println(
                    "Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate()
            );
        }
 
        HibernateUtil.getSessionFactory().close();
    }
 
    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
 
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);
 
        session.getTransaction().commit();
    }
 
    private List listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }
 
}
				*/