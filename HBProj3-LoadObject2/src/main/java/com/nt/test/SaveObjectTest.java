package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		//build session
		Session ses=factory.openSession();
	try(factory;ses){
		//load object using get(-,-)method
	//Product prod=ses.get(Product.class, 1001);
	Product prod=ses.load(Product.class, 1001);
	System.out.println(prod.getClass()+" "+prod.getClass().getSuperclass());
System.out.println("=============");		
			System.out.println(prod.getPid()+" "+prod.getPname()+" "+prod.getPrice()+" "+prod.getQty());
	}	
		catch(HibernateException he) {
			System.out.println("Record not found");
			he.printStackTrace();
		
	
		}
}
}