package dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.new_itemVO;
import vo.orderVO;
import vo.loginVO;

public class orderDAO {
	
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
	public List companydisplay(String s)
	{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from orderVO where rights like '"+s+"'");
		List orderlist = view.list();
		return orderlist;
		
	}
	
	public List distributordisplay(int s)
	{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from orderVO where userid like '"+s+"'");
		List orderlist = view.list();
		return orderlist;
		
	}
	public List displayorderdetail(orderVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from orderVO where id like '"+v.getId()+"'");
		List orderlist = view.list();
		return orderlist;
	}
	
	public void delete(orderVO v)
	{
		try{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  Query q = session.createQuery("delete from orderVO where id like'"+v.getId()+"'");
			  q.executeUpdate();
			  tr.commit();
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		
		
	}
	
	public List knowname(int id )
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from loginVO where userid like '"+id+"'");
		List suppname = view.list();
		return suppname;
		
		
	
	}
	
	public List supplierdisplay(String s)
	{
		String s1 = "distributor";
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from orderVO where supplier like '"+s+"' AND rights like '"+s1+"'");
		List orderlist = view.list();
		return orderlist;
		
	}
	
	
}
