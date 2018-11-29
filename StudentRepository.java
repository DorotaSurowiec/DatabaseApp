package studentdatabaseapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
	
	private static StudentRepository instance;
	
	private List<Student> students = new ArrayList<>();
	
	private StudentRepository() {}
	
	public static StudentRepository getInstance() {
		if (instance == null) {
			instance = new StudentRepository();
		}
		return instance;
	}
	
	public void save(Student student) {
		students.add(student);
	}
	
	public Optional<Student> findByStudentId(int studentId) {
		for (Student student : students) {
			if (studentId == student.getStudentId()) {
				return Optional.of(student);
			}
		}
		return Optional.empty();
	}
	
	public List<Student> findByStudentSurname(String studentSurname) {
		List<Student> result = new LinkedList<>();
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if (studentSurname.equalsIgnoreCase(student.getSurname())) {
				result.add(student);
			}
		}
		return result;
	}
	
	public List<Student> findAll() {
		List<Student> result = new LinkedList<>();
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			result.add(student);
		}
		return result;
	}
	
	public List<Student> studentsAttendToCourse(String nameCourse) {
		Optional<BaseCourse> optionalCourse = CourseRepository.getInstance().findByName(nameCourse);
		if (optionalCourse.isPresent()) {
			return optionalCourse.get().getRegisteredStudents();
		}
		return new ArrayList();
	}
	
	public List<BaseCourse> allCoursesOfStudent(int studentId) {
		for (Student student : students) {
			if (studentId == student.getStudentId()) {
				return ((Student) student).getRegisteredCourses();
			}
		}
		return new ArrayList();
	}
}
