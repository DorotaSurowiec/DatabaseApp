package studentdatabaseapp;

import java.util.Date;
import java.util.Scanner;

public class CreateStudentStrategy implements MenuStrategy {

	private int studentID = 100000;
	private StudentRepository studentRepository = StudentRepository.getInstance();

	public boolean accept(int choosenOperation) {
		return choosenOperation == 1;
	}

	public void run() {
		Scanner in = new Scanner(System.in);
		System.out.println("Wpisz imiê nowego studenta:");
		String name = in.next();
		System.out.println("Wpisz nazwisko nowego studenta:");
		String surname = in.next();
		
		Student student = new Student(studentID, name, surname, new Date());
		
		studentRepository.save(student);
		studentID +=1;
	}

}
