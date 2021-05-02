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
		config.addAnnotatedClass(Phone.class);

		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory sf = config.buildSessionFactory(reg.build());
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		/*
		 * Operation: Normal DB Operation with hbm2ddl.auto value as Update Student
		 * s=new Student(); s.setRno(4); s.setName("Umang"); s.setMarks(80);
		 * s.setBacklog(2); session.save(s);
		 * 
		 */

		/*
		 * Operation: One to One Relation
		 * 
		 * Employee emp1=new Employee(); emp1.setId(101); emp1.setName("Hassan");
		 * 
		 * Employee emp2=new Employee(); emp2.setId(102); emp2.setName("HK");
		 * 
		 * Company company=new Company(); company.setId(9000);
		 * company.setName("Axelor");
		 * 
		 * emp1.setCompany(company); emp2.setCompany(company);
		 * 
		 * session.save(emp1); session.save(emp2); session.save(company);
		 */

		/*
		 * Operation: One to Many Relation 
		 *
		 * Employee emp3=new Employee();
		 *
		 * emp3.setId(103); emp3.setName("Hancy");
		 * 
		 * Phone p1=new Phone(); p1.setId(901); p1.setNumber("9925897864");
		 * 
		 * Phone p2=new Phone(); p2.setId(902); p2.setNumber("9825264187");
		 * 
		 * emp3.getPhone().add(p1); emp3.getPhone().add(p2);
		 * 
		 * session.save(emp3); session.save(p1); session.save(p2);
		 */
		
		Employee emp4=new Employee();
		emp4.setId(104);
		emp4.setName("Kap");
		
		Phone p3=new Phone();
		p3.setId(903);
		p3.setNumber("9904433185");
		p3.setEmployee(emp4);
		
		Phone p4=new Phone();
		p4.setId(904);
		p4.setNumber("9898230786");
		p4.setEmployee(emp4);
		
		session.save(emp4);
		session.save(p3);
		session.save(p4);

		transaction.commit();
		session.close();
	}
}
