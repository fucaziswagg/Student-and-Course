package assignment7;

public class Student {
	
	/**
	 * instance variables
	 */
	private String firstName, lastName;
	private int studentID;
	private double bBBalnce, attemptCredits, passCredits, totalGradeQPoints;
	
	/**
	 * constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param iD
	 */
	public Student(String firstName, String lastName, int iD) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = iD;
		this.attemptCredits = 0;
		this.passCredits = 0;
		this.totalGradeQPoints = 0;
		this.bBBalnce = 0;
	}
	
	/**
	 * getter
	 * @return full name of student as a string
	 */
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	/**
	 * getter
	 * @return student ID# as in integer
	 */
	public int getId() {
		return this.studentID;
	}
	
	/**
	 * setter
	 * submits a grade for a course worth some credits
	 * @param grade
	 * @param credits
	 */
	public void submitGrade(double grade, double credits) {
		this.attemptCredits = this.attemptCredits + credits;
		this.totalGradeQPoints = this.totalGradeQPoints + (grade * credits);
		if (grade >= 1.7) {
			this.passCredits = this.passCredits + credits;
		}
	}
	
	/**
	 * getter
	 * @return the total number of attempted credits as a double
	 */
	public double getTotalAttemptedCredits() {
		return this.attemptCredits;
	}
	
	/**
	 * getter
	 * @return the students total passing credits as a double
	 */
	public double getTotalPassingCredits() {
		return this.passCredits;
	}
	
	/**
	 * getter
	 * @return the students GPA as a double
	 */
	public double calculateGradePointAverage() {
		double gPA = this.totalGradeQPoints / this.attemptCredits;
		return gPA;
	}
	
	/**
	 * getter
	 * @return the Students grade as a string based on their passing credits
	 */
	public String getClassStanding() {
		if (this.passCredits < 30)
			return "First Year";
		else if (this.passCredits >= 30 && this.passCredits < 60)
			return "Sophomore";
		else if (this.passCredits >= 60 && this.passCredits < 90)
			return "Junior";
		else if (this.passCredits >= 90)
			return "Senior";
		
		return "";
	}
	
	/**
	 * getter
	 * @return whether the student meets the given requirements
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (getTotalPassingCredits() >= 98 && calculateGradePointAverage() >= 3.6) {
			return true;
		}
		else
			return (getTotalPassingCredits() >= 75 && calculateGradePointAverage() >= 3.8);
	}
	
	/**
	 * setter - changes the current BB balance
	 * @param amount
	 */
	public void setBearBucks(double amount) {
		this.bBBalnce = amount;
	}
	
	/**
	 * setter - sets the new BB balance after money is deposited
	 * @param deposit
	 */
	public void depositBearBucks(double deposit) {
		this.bBBalnce = this.bBBalnce + deposit;
	}
	
	/**
	 * setter - sets the new BB balance after money is deducted
	 * @param deduction
	 */
	public void deductBearBucks(double deduction) {
		if (deduction <= this.bBBalnce)
			this.bBBalnce = this.bBBalnce - deduction;
	}
	
	/**
	 * getter
	 * @return the current BB balance as a double
	 */
	public double getBearBucksBalance() {
		return this.bBBalnce;
	}
	
	/**
	 * getter
	 * @return the total amount the student receives of his BB balance
	 */
	public double cashOutBearBucks() {
		double cash = this.bBBalnce - 10;
		this.bBBalnce = 0;
		if (cash >= 0) {
			return cash;
		}
		else {
			cash = 0;
			return cash;
		}
	}
	
	/**
	 * setter 
	 * @param firstName
	 * @param otherParent
	 * @param isHyphenated
	 * @param iD
	 * @return makes the "child" of the current student (which won't return any physical values)
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int iD) {
		if (isHyphenated) {
			Student legacy = new Student(firstName, this.lastName + "-" + otherParent.lastName, iD);
			legacy.setBearBucks(cashOutBearBucks() + otherParent.cashOutBearBucks());
			return legacy;
		}
		else {
			Student legacy = new Student(firstName, this.lastName, iD);
			legacy.setBearBucks(cashOutBearBucks() + otherParent.cashOutBearBucks());
			return legacy;
		}
	}
	
	/**
	 * getter
	 * @return the students full name and ID number as a string
	 */
	public String toString() {
		return getFullName() + getId();
	}
	
}
