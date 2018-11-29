package studentdatabaseapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class CourseRepository {

	private static CourseRepository instance;
	
	private CourseRepository() {}
	
	public static CourseRepository getInstance() {
		if (instance == null) {
			instance = new CourseRepository();
		}
		
		return instance;
	}
	
	private static Map<String, BaseCourse> allCourses = new HashMap<>();
	static {
		allCourses.put("Matematyka", new MathCourse());
		allCourses.put("Historia", new HistoryCourse());
	}
	
	public List<BaseCourse> showAll() {
		return new ArrayList<>(allCourses.values());
	}
	
	public Optional<BaseCourse> findByName(String name) {
		for (String courseName : allCourses.keySet()) {
			if (courseName.equalsIgnoreCase(name)){
				return Optional.of(allCourses.get(courseName));
			}
		}
		return Optional.empty();
	}
	
}
