package studentdatabaseapp;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCourse {
	
	protected String name;
	
	protected int cost;

	protected List<Student> registeredStudents = new ArrayList<>();
	
	public BaseCourse() {
		
	}
	
	protected BaseCourse(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}
	
	public void registerStudent(Student student) {
		registeredStudents.add(student);
	}
	
	public List<Student> getRegisteredStudents() {
		return registeredStudents;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
