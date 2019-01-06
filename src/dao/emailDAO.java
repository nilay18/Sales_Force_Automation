package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import vo.loginVO;

public class emailDAO {
	
	
	public List authenticate(String email) {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
		 try
		 {
			 SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			 Session session=sessionFactory.openSession();
			 Query q=session.createQuery("from loginVO where emailid like '"+email+"'");
			 ls=q.list();
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return ls;
	}

}
