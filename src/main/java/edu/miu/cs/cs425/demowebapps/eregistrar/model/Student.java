package edu.miu.cs.cs425.demowebapps.eregistrar.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name="student_number", unique = true, nullable = false)
    private String studentNumber;

    private String firstName;
    private String lastName;
    private Float cgpa;

    @Column(name = "admission_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate admissionDate;
    private Boolean isInternational;


    public Student() {
    }

    public Student(String studentNumber, String firstName, String lastName,
    		Float cgpa, LocalDate admissionDate, Boolean isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.admissionDate = admissionDate;
        this.isInternational = isInternational;
        
    }
    
    public Student(Integer studentId, String studentNumber, String firstName,
    		String lastName, Float cgpa, LocalDate admissionDate, Boolean isInternational) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.admissionDate = admissionDate;
        this.isInternational = isInternational;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    
	public Boolean getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(Boolean isInternational) {
		this.isInternational = isInternational;
	}

	@Override
	public String toString() {
		return String.format(
				"Student [studentId=%s, studentNumber=%s, firstName=%s, lastName=%s, cgpa=%s, admissionDate=%s, isInternational=%s]",
				studentId, studentNumber, firstName, lastName, cgpa, admissionDate, isInternational);
	}

	



 
}
