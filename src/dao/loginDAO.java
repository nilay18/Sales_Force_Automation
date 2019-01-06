package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.loginVO;




public class loginDAO {
	
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

	public void authenticate( )
	{
		// TODO Auto-generated method stub
		
		 try
		 {
			 SessionFactory sessionFactory=new Configuration().configure

().buildSessionFactory();
			 Session session=sessionFactory.openSession();
			 
			 Transaction tr=session.beginTransaction();
			
			 tr.commit();
			 
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

	}

	public List authenticate(loginVO lv) {
		// TODO Auto-generated method stub
		List ls=new ArrayList();
		 try
		 {
			 SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			 Session session=sessionFactory.openSession();
			 Query q=session.createQuery("from loginVO where uname='"+lv.getUname()+"'and pass='"+lv.getPass()+"'");
			 ls=q.list();
			 System.out.println(ls.size());
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return ls;
	}

	}
