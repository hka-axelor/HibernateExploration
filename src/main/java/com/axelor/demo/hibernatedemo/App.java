package com.axelor.demo.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration config=new Configuration().configure("hibernate.cfg.xml");
    	config.addAnnotatedClass(Student.class);
    	StandardServiceRegistryBuilder reg=new StandardServiceRegistryBuilder().applySettings(config.getProperties());
    	SessionFactory sf=config.buildSessionFactory(reg.build());
    	Session session=sf.openSession();
    	Transaction transaction=session.beginTransaction();
    	
    	Student s=new Student();
    	s.setRno(4);
    	s.setName("Umang");
    	s.setMarks(80);
    	s.setBacklog(2);
    	
    	session.save(s);
    	transaction.commit();
    	session.close();
    }
}
