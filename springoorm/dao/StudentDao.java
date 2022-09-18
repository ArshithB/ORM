package com.springoorm.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springoorm.entities.Student;



public class StudentDao {
		@Autowired
		private HibernateTemplate hibernateTemplate;
		
		@Transactional
		public int insert(Student student) {
			int i=(Integer) this.hibernateTemplate.save(student);
			return i;
		}

		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
			@Transactional
		    public int insert1(Student student) {
		        int i=(Integer)this.hibernateTemplate.save(student);
		        return i;
		    }
		    //get the single data(object)--read operation
		    public Student getStudent(int studentId) {
		        Student student=this.hibernateTemplate.get(Student.class,studentId);
		        return student;
		    }
		    //get the all data(objects)--read all operation
		    public List getAllStudents(){
		        List students =(List) this.hibernateTemplate.loadAll(Student.class);
		        return students;
		    }
		    //for delete data
		    @Transactional
		    public void deleteStudent(int studentId) {
		    	Student student = this.hibernateTemplate.get(Student.class, studentId);
		    this.hibernateTemplate.delete(student);
		    
		    }
		    //update the data
		    @Transactional
		    public void updateStudent(Student student) {
		        this.hibernateTemplate.update(student);
		    }
		}