package edu.miu.cs.cs425.demowebapps.eregistrar.services.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs425.demowebapps.eregistrar.Repository.StudentRepository;
import edu.miu.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.miu.cs.cs425.demowebapps.eregistrar.services.StudentService;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student s) {
		return studentRepository.save(s);
	}

	@Override
	public Student getStudentById(Integer studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public void deleteStudentById(Integer studentId) {
		studentRepository.deleteById(studentId);
		
	}

	

}
