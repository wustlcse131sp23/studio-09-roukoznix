
package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int IDnum;
	private int creditsAttempted;
	private int passingCredits;
	private double totalGQP;
	private double bearBucksBalance;
	

	/**
	 * constructor method for student
	 * @param fName first name
	 * @param lName last name
	 * @param n id number
	 */
	public Student(String fName, String lName, int n) { // constructor
		this.firstName = fName;
		this.lastName = lName;
		this.IDnum = n;	
	}
	
	/**
	 * getter method for full name of student
	 * @return  first and last names with a space between them
	 */
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * getter method for ID number of student
	 * @return  students ID number
	 */
	public int getId() {
		return this.IDnum;
	}
	
	/**
	 * getter method for total attempted credits
	 * @return  total attempted credits
	 */
	public int getTotalAttemptedCredits() {
		
		return this.creditsAttempted;
	}
	
	/**
	 * getter method for total passing credits
	 * @return  total passing credits
	 */
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}
	
	/**
	 * calculates GPA using total GQP and total attempted credits
	 * @return  GPA
	 */
	public double calculateGradePointAverage() {
		return this.totalGQP / this.getTotalAttemptedCredits();
	}
	
	/**
	 * adjusts credits and GQP every time a final course grade is submitted
	 */
	public void submitGrade(double grade, int credits) {
		this.creditsAttempted = this.creditsAttempted + credits;
		if (grade >= 1.7) {
			this.passingCredits = this.passingCredits + credits;
		}
		else this.passingCredits = this.passingCredits;
		
		this.totalGQP = this.totalGQP + (grade*credits);
		//FIXME: what.
	}
	
	/**
	 * getter method for class standing of student
	 * @return  class standing
	 */
	public String getClassStanding() {
		if (this.getTotalPassingCredits() < 30) { return "First Year";}
		else if (this.getTotalPassingCredits() >= 30 && this.getTotalPassingCredits() < 60) {return "Sophomore";}
		else if (this.getTotalPassingCredits() >= 60 && this.getTotalPassingCredits() < 90) {return "Junior";}
		else {return "Senior";}
		
	}
	
	/**
	 * method which returns true if student is eligible for PhiBK and false if they are not
	 * @return  true or false
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if ((this.calculateGradePointAverage() >= 3.60 && this.getTotalPassingCredits() >= 98) || (this.calculateGradePointAverage() >= 3.80 && this.getTotalPassingCredits() >= 75)) {
			return true;
		}
		else return false;
	}
	
	/**
	 * @param amount amount deposited
	 * changes the value of bear bucks balance
	 */
	public void depositBearBucks(double amount) {
		this.bearBucksBalance = getBearBucksBalance() + amount;
	}
	
	/**
	 * @param amount amount deducted
	 * changes the value of bear bucks balance
	 */
	public void deductBearBucks(double amount) {
		this.bearBucksBalance = getBearBucksBalance() - amount;
	}
	
	/**
	 * @return current bear bucks balance of student
	 */
	public double getBearBucksBalance() {
		return this.bearBucksBalance;
	}
	
	/**
	 * sets bear bucks balance to zero and returns remaining balance minus a fee
	 */
	public double cashOutBearBucks() {
		if (getBearBucksBalance() > 10.00) {
			double remainingBalance = getBearBucksBalance();
			double refund = remainingBalance - 10.00;
			this.bearBucksBalance = 0.0;
			return refund;
		}
		else {
			this.bearBucksBalance = 0.0;
			return 0.0;
		}
	}
	
	/**
	 * @param firstName
	 * @param otherParent
	 * @param isHyphenated
	 * @param id
	 * 
	 * creates a new student who is the child of two former students. student is given their remaining bear bucks balance after cashing out.
	 * student's name will be hyphenated if ifHyphenated is true.
	 * @return child
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		String lName;
		if (isHyphenated != true) {
			lName = this.lastName;
		}
		else{
			lName = this.lastName + "-" + otherParent.lastName;
		}
		Student child = new Student(firstName, lName, id);
		child.bearBucksBalance = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
		return child;
	}
	
	/**
	 * @return returns a student's full name and id number
	 */
	public String toString() {
		return getFullName() + " " + getId();
	}
	
	
	
}
