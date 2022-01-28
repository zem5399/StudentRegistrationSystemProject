package edu.miu.cs.cs425.demowebapps.eregistrar.services;

import java.util.List;

import edu.miu.cs.cs425.demowebapps.eregistrar.model.Student;

public interface StudentService {
	public abstract List<Student> getAllStudents();
	public abstract Student saveStudent(Student s);
	public abstract Student getStudentById(Integer bookId);
	public abstract void deleteStudentById(Integer studentId);
	
}
