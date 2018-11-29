package studentdatabaseapp;

import java.util.List;
import java.util.Scanner;

public class StudentsAttendingToCourseStrategy implements MenuStrategy {
	
	public boolean accept(int choosenOperation) {
		return choosenOperation == 7;
	}

	public void run() {
		StudentRepository studentRepository = StudentRepository.getInstance();
		
		System.out.println("Wpisz nazwe kursu\n");
		Scanner in = new Scanner(System.in);
		String nameCourse = in.nextLine();
		
		List<Student> result = studentRepository.studentsAttendToCourse(nameCourse);
		for (Student student : result) {
			System.out.println(student);
		}
	}

}
