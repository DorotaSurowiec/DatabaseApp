package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentDatabaseApp {
	
	static List<MenuStrategy> menu;
	
	public static void main(String[] args) {
		initStrategies();
//		1. Utwórz studenta
//		2. Wyœwietl wszystkich studentów
//		3. Wyœwietl dostêpne przedmioty
//		4. Zarejestruj studenta na przedmiot
//		5. Znajdz studenta po ID, po nazwisku
//		6. Wypisz zapisanych studentów na kurs
//		7. Wypisz wszystkie kursy studenta znalezionego po ID
		boolean running = true;

		while (running = true) {
			System.out.println("MENU:\n1. Utwórz studenta\n2. Wyœwietl wszystkich studentów\n3. Wyœwietl dostêpne przedmioty\n"
				+ "4. Zarejestruj studenta na przedmiot\n5. Znajdz studenta po ID\n6. Znajdz studenta po nazwisku\n"
				+ "7. Wypisz zapisanych studentów na kurs\n8. Wypisz wszystkie kursy studenta znalezionego po ID\n");
		
			Scanner in = new Scanner(System.in);
			int choosenOperation = in.nextInt();
			
			for (MenuStrategy strategy : menu) {
				if (strategy.accept(choosenOperation)) {
					strategy.run();
				}
			}
		}
		
	}
	
	private static void initStrategies() {
		menu = new ArrayList<>();
		menu.add(new CreateStudentStrategy());
		menu.add(new ShowAllStudentsStrategy());
		menu.add(new ShowAvailableCoursesStrategy());
		menu.add(new StudentsRegisterStrategy());
		menu.add(new FindByStudentIdStrategy());
		menu.add(new FindByStudentSurnameStrategy());
		menu.add(new StudentsAttendingToCourseStrategy());
		menu.add(new FindAllStudentsCoursesStrategy());
	}

}