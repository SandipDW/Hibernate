package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {

	public static void main(String[] args) {
		//bootstarp/Activate the bootsrap
		Configuration cfg=new Configuration();
		//specify the hibernate cfs file and location
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//build session factory having all services specifid in cfg file and mapping file
		SessionFactory factory=cfg.buildSessionFactory();
		//creat eseesion objecy
		Session ses=factory.openSession();
		Transaction tx=null;
		try {
			tx=ses.beginTransaction();//internally calls con.setAutocommit(false) to disable auto commit mode on db s/w
			//prepare entity object
			Product prod=new Product();
			prod.setPid(1002);prod.setPname("chair");prod.setPrice(502.25f);prod.setQty(5.0f);
			//save object
			ses.save(prod);//give spersistence instruction to hibernate to save objecr (inset object data asa a record)
			tx.commit();//internally calls con.commit() method to make insertion executing result permanent.
			System.out.println("Object is saved(Record is inserted)");
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		tx.rollback();
	System.out.println("Object is not saved (Record is not inserted)");
		}
		ses.close();
		factory.close();
		}
}
