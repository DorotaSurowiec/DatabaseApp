package studentdatabaseapp;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class StudentsRegisterStrategy implements MenuStrategy {

	public boolean accept(int choosenOperation) {
		return (choosenOperation == 4);
	}

	public void run() {
		StudentRepository studentRepository = StudentRepository.getInstance();
		CourseRepository courseRepository = CourseRepository.getInstance();
		
		int studentId = ScannerUtils.readInt("Podaj nr albumu studenta, ktorego chcesz zapisac");

		Optional<Student> studentOptional = studentRepository.findByStudentId(studentId);
		if (!studentOptional.isPresent()) {
			System.out.println("Nie ma takiego studenta!");
			return;
		}
		Student student = studentOptional.get();
		System.out.println("Podaj nazwê przedmiotu na jaki chcesz zapisaæ studenta");
		Scanner in = new Scanner(System.in);
		String courseName = in.next();
		Optional<BaseCourse> courseOptional = courseRepository.findByName(courseName);
		if (!courseOptional.isPresent()) {
			System.out.println("Nie ma takiego kursu!");
			return;
		}
		BaseCourse course = courseOptional.get();
		course.registerStudent(student);
		student.register(course);
		System.out.println("Student " + student.getName() + " " + student.getSurname() + " zarejestrowany na kurs " + course.getName());
	}

}
