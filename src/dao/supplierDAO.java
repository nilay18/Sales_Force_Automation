package dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.new_itemVO;
import vo.supplierVO;


public class supplierDAO 
{
	
	public void insert(Object v){
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try{
			session.save(v);
			tr.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
	
	public List display()
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from supplierVO");
		List supplist = view.list();
		return supplist;
		
	}

	
	public List displaysupplierdetail(supplierVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from supplierVO where id like '"+v.getIds()+"'");
		List supplierlist = view.list();
		return supplierlist;
	}
	
	public void delete(supplierVO v)
	{
		try{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  Session session =sessionFactory.openSession();
			  Transaction tr = session.beginTransaction();
			  Query q = session.createQuery("delete from supplierVO where id like'"+v.getIds()+"'");
			  q.executeUpdate();
			  tr.commit();
			  
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		
		
	}
	
	public void update(supplierVO v)
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
