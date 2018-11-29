package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
	
	private int studentId;
	private String name;
	private String surname;
	private Date registerDate;
	private List<BaseCourse> registeredCourses = new ArrayList<>();
	
	public Student(int studentId, String name, String surname, Date registerDate) {
		this.studentId = studentId;
		this.name = name;
		this.surname = surname;
		this.registerDate = registerDate;
	}

	public void register(BaseCourse course) {
		registeredCourses.add(course);
	}
	
	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getRegisterDate() {
		return registerDate;
	}
	
	public List<BaseCourse> getRegisteredCourses() {
		return registeredCourses;
	}

	@Override
	public String toString() {
		return studentId + "|" + name + "|" + surname;
	}	
	
}
