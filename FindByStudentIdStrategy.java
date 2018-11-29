package studentdatabaseapp;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class FindByStudentIdStrategy implements MenuStrategy {

	public boolean accept(int choosenOperation) {
		return choosenOperation == 5;
	} 

	public void run() {
		StudentRepository studentRepository = StudentRepository.getInstance();
		
		int searchingStudentId = ScannerUtils.readInt("Wpisz nr albumu studenta:");
		
		Optional <Student> studentOptional = studentRepository.findByStudentId(searchingStudentId);
		if(!studentOptional.isPresent()) {
			System.out.println("Nie ma takiego studenta!");
			return;
		} 
		
		Student student = studentOptional.get();
		System.out.println("Student: " + student);
	}

}
