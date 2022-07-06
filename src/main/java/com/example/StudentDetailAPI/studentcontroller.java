package com.example.StudentDetailAPI;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentcontroller {

	@Autowired
	SessionFactory factory;

	@PostMapping("/CreateTable")
	public ArrayList<StudentDetails> fetchStudenData()
	{
		ArrayList<StudentDetails> al  = new ArrayList<StudentDetails>();
		Session session = factory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();

		StudentDetails details = new StudentDetails(1, "Saurabh", "Bsc", "Male", "Pune");
		StudentDetails details1 = new StudentDetails(2, "Ishwar", "BE", "Male", "Satara");
		StudentDetails details2 = new StudentDetails(3, "Vaibhav", "ME", "Male", "Kolhapur");
		al.add(details1);
		al.add(details2);
		al.add(details);
		transaction.commit();
		session.close();
		return al;
		
		
	} 
	@GetMapping("/LoadData")
	public StudentDetails m1() {
		Session session=factory.openSession();
		StudentDetails details1 = session.load(StudentDetails.class, 1);
		return details1;
				
	}
	@GetMapping("loadAllData")
	public ArrayList<StudentDetails> m2() {
		ArrayList<StudentDetails> al = new ArrayList<StudentDetails>();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(StudentDetails.class);
		ArrayList<StudentDetails> al1 = (ArrayList<StudentDetails>) criteria.list();
		return al1;
		
	}
	
	
	@PutMapping("/updateStudent/{id}")
	
	public StudentDetails updateStudentById(@PathVariable int id) {
	
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
	      StudentDetails s=session.get(StudentDetails.class, id);
	    
	     s.setName("mahendra");
	     s.setCity("bhopal");
	     s.setCource_name("mca");
	     s.setGender("male");
	      session.update(s);
	      session.save(s);
	                tx.commit();
	             		return s;
		
		
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	
	public StudentDetails deleteStudentById(@PathVariable int id) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		StudentDetails stu=session.get(StudentDetails.class, 1);
		session.delete(stu);
		tx.commit();
		
		return stu;
	
	}}

