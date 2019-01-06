package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import vo.customerVO;
import vo.new_itemVO;
import vo.orderVO;
import vo.sellVO;

public class reportDAO {
	
	public List display_csales(sellVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from sellVO where customer like '"+v.getCustomer()+"'");
		List sales_customer = view.list();
		return sales_customer;
		
	}
	
	public List display_isales(sellVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from sellVO where iname like '"+v.getIname()+"'");
		List sales_item = view.list();
		return sales_item;
		
	}
	
	public List display_sorder(orderVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from orderVO where supplier like '"+v.getSupplier()+"'");
		List order_supp = view.list();
		return order_supp;
		
	}
	
	public List display_iorder(orderVO v)
	{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view = session.createQuery("from orderVO where iname like '"+v.getIname()+"'");
		List order_item = view.list();
		return order_item;
		
	}

}
