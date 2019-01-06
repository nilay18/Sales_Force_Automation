package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.new_itemVO;

public class new_itemDAO {

	
	public void insert(Object v){
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
		Query view  = session.createQuery("from new_itemVO");
		List itemlist = view.list();
		return itemlist;
		
	}
	public List total_cost(new_itemVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from new_itemVO where iname like '"+v.getIname()+"'");
		List itemdetail = view.list();
		return itemdetail;
		
		
	}
	
	public List total_price(new_itemVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from new_itemVO where iname like '"+v.getIname()+"'");
		List itemdetail = view.list();
		return itemdetail;	
		
	}
	
	public List displayitemdetail(new_itemVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from new_itemVO where id like '"+v.getId()+"'");
		List itemlist = view.list();
		return itemlist;
	}
	
	public void delete(new_itemVO v)
	{
		try{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  Query q = session.createQuery("delete from new_itemVO where id like'"+v.getId()+"'");
			  q.executeUpdate();
			  tr.commit();
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		
		
	}
	
	public void update(new_itemVO v)
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
