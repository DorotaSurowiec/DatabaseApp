package studentdatabaseapp;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FindAllStudentsCoursesStrategy implements MenuStrategy {

	@Override
	public boolean accept(int choosenOperation) {
		return choosenOperation == 8;
	}

	@Override
	public void run() {
		int studentId = ScannerUtils.readInt("Wpisz nr albumu studenta:");
				
		List<BaseCourse> result = StudentRepository.getInstance().allCoursesOfStudent(studentId);
		for (BaseCourse courses : result) {
			System.out.println(courses);
		}
		
	}

}
