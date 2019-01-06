package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class profitDAO {
	
	public List today_profit()
	{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from sellVO where sdate = CURDATE()");
		List saleslist = view.list();
		return saleslist;
	
	}
	
	public List yes_profit()
	{
		

		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from sellVO where sdate = CURDATE()-1");
		List saleslist = view.list();
		return saleslist;
		
	}
	
	public List week_profit()
	{
		

		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from sellVO where sdate <= CURDATE() AND sdate >=CURDATE()-7");
		List saleslist = view.list();
		return saleslist;
		
	}
	
	public List month_profit()
	{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from sellVO where MONTH(sdate) = MONTH(CURDATE()) ");
		List saleslist = view.list();
		return saleslist;
		
	}
	
	public List lastmon_profit()
	{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from sellVO where MONTH(sdate) = MONTH(CURDATE())-1 ");
		List saleslist = view.list();
		return saleslist;
		
	}
	
	public List year_profit()
	{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from sellVO where YEAR(sdate) = YEAR(CURDATE()) ");
		List saleslist = view.list();
		return saleslist;
		
	}
	
	public List lastyear_profit()
	{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		Query view  = session.createQuery("from sellVO where YEAR(sdate) = YEAR(CURDATE())-1 ");
		List saleslist = view.list();
		return saleslist;
		
	}

}
