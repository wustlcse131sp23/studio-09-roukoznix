package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;



public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> database = new HashMap<>();
	
	public UniversityDatabase() {
		Map<String, Student> database = new HashMap<>();
	}
	
	public void addStudent(String accountName, Student student) {
		database.put(accountName, student);
	}

	

	public int getStudentCount() {
		return database.size();
	}

	public String lookupFullName(String accountName) {
		Student student = database.get(accountName);
		if (student != null)
			return student.getFullName();
		else
			return null;
	}

	public double getTotalBearBucks() {
		double total = 0.0;
		for (Student student : database.values()) {
			total = total + student.getBearBucksBalance();
		}
		return total;
	}
}
