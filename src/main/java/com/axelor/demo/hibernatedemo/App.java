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
public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(Student.class);
		config.addAnnotatedClass(Employee.class);
		config.addAnnotatedClass(Company.class);
		
		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory sf = config.buildSessionFactory(reg.build());
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		/*
		 * Operation: Normal DB Operation with hbm2ddl.auto value as Update
		 * Student s=new Student(); s.setRno(4); s.setName("Umang"); s.setMarks(80);
		 * s.setBacklog(2); session.save(s);
		 * 
		 */
		
		Employee emp1=new Employee();
		emp1.setId(101);
		emp1.setName("Hassan");
		
		Employee emp2=new Employee();
		emp2.setId(102);
		emp2.setName("HK");
		
		Company company=new Company();
		company.setId(9000);
		company.setName("Axelor");
		
		emp1.setCompany(company);
		emp2.setCompany(company);
		
		session.save(emp1);
		session.save(emp2);
		session.save(company);
		
		transaction.commit();
		session.close();
	}
}
