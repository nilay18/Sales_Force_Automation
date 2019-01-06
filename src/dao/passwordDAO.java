package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.loginVO;

public class passwordDAO {

	public void update(loginVO v)
	{
		
		try
		{
			 
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  session.update(v);
			  tr.commit();
		}
		catch(Exception e){}
	}
}
