package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.categoryVO;

public class categoryDAO {
	public void insert(categoryVO v){
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try{
			session.save(v);
			tr.commit();
		}
		catch(Exception e){}
	}
	
	public List display()
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from categoryVO");
		List catlist = view.list();
		return catlist;
		
	}
	
	public void delete(categoryVO v)
	{
		try{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  Query q = session.createQuery("delete from categoryVO where id like'"+v.getId()+"'");
			  q.executeUpdate();
			  tr.commit();
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		
		
	}

}
