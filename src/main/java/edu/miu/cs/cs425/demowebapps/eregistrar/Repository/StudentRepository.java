package edu.miu.cs.cs425.demowebapps.eregistrar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs425.demowebapps.eregistrar.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

	   
}
