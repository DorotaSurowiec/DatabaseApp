package studentdatabaseapp;

import java.util.List;

public class ShowAllStudentsStrategy implements MenuStrategy {

	public boolean accept(int choosenOperation) {
		return choosenOperation == 2;
	}

	public void run() {
		List<Student> students = StudentRepository.getInstance().findAll();
		
		if (students.isEmpty()) {
			System.out.println("Nie ma studentow\n");
			return;
		}
		
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
