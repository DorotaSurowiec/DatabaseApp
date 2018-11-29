package studentdatabaseapp;

import java.util.List;
import java.util.Set;

public class ShowAvailableCoursesStrategy implements MenuStrategy {

	public boolean accept(int choosenOperation) {
		return choosenOperation == 3;
	}

	public void run() {//
		List<BaseCourse> courses = CourseRepository.getInstance().showAll();
		for (BaseCourse przedmiot : courses) {
			System.out.println(przedmiot);
		}
	}

}
