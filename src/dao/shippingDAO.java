package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.shippingVO;

public class shippingDAO {

	
	public void insert(shippingVO v){
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
		Query view  = session.createQuery("from shippingVO");
		List carlist = view.list();
		return carlist;
		
	}
	
	public void delete(shippingVO v)
	{
		try{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  Query q = session.createQuery("delete from shippingVO where id like'"+v.getId()+"'");
			  q.executeUpdate();
			  tr.commit();
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		
		
	}
}
