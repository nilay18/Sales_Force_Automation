package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.customerVO;
import vo.new_itemVO;

public class customerDAO {
	
	
	public void insert(customerVO v){
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
		Query view  = session.createQuery("from customerVO");
		List customerlist = view.list();
		return customerlist;
		
	}
	
	public List displaycustomerdetail(customerVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from customerVO where id like '"+v.getId()+"'");
		List customerlist = view.list();
		return customerlist;
	}
	
	public void delete(customerVO v)
	{
		try{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  Query q = session.createQuery("delete from customerVO where id like'"+v.getId()+"'");
			  q.executeUpdate();
			  tr.commit();
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		
		
	}

	public void update(customerVO v)
	{
		
		try
		{
			 
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  session.saveOrUpdate(v);
			  tr.commit();
		}
		catch(Exception e){}
	}
}
