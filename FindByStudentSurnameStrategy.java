package studentdatabaseapp;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FindByStudentSurnameStrategy implements MenuStrategy {

	public boolean accept(int choosenOperation) {
		return choosenOperation == 6;
	}

	public void run() {
		StudentRepository studentRepository = StudentRepository.getInstance();
		
		System.out.println("Wpisz nazwisko studenta:\n");
		Scanner in = new Scanner(System.in);
		String searchingStudentSurname = in.nextLine();
		
		List<Student> students = studentRepository.findByStudentSurname(searchingStudentSurname);
		if (students.isEmpty()) {
			System.out.println("Nie odnaleziono studentów o nazwisku " + searchingStudentSurname);
			return;
		}
		
		for (Student student : students) {
			System.out.println(student);
		}
		
	}

}
