package assignment7;

public class Course {
	
	/**
	 * instance variables
	 */
	private String courseName;
	private int enrolledStudents, capacity, credits;
	private Student[] roster;
	
	/**
	 * constructor
	 * @param name
	 * @param credits
	 * @param capacity
	 */
	public Course(String name, int credits, int capacity) {
		this.courseName = name;
		this.credits = credits;
		this.enrolledStudents = 0;
		this.capacity = capacity;
		this.roster = new Student[this.capacity];
	}
	
	/**
	 * getter
	 * @return the name of the course as a string
	 */
	public String getName() {
		return this.courseName;
	}
	/**
	 * getter
	 * @return the credits of the course as an integer
	 */
	public int getCredits() {
		return this.credits;
	}
	/**
	 * getter
	 * @return the possible amount of students that can enroll as in integer
	 */
	public int getCapacity() {
		return this.capacity;
	}
	/**
	 * getter
	 * @return the current number of enrolled students as an integer
	 */
	public int getEnrolledStudents() {
		return this.enrolledStudents;
	}
	/**
	 * getter
	 * @return the current number of seats available as an integer >= 0
	 */
	public int getSeatsRemaining() {
		int sR = this.capacity - this.enrolledStudents;
		if (sR < 0) {
			sR = 0;
		}
		return sR;
	}
	
	/**
	 * setter - adds the student to the course roster if possible
	 * @param s - the student to be added
	 * @return whether or not the student can be added
	 */
	public boolean addStudent(Student s) {
		if (this.getSeatsRemaining() == 0) {
			return false;
		}
		else {
			for (int i=0; i < (this.capacity - this.getSeatsRemaining()); ++i) {
				if (s == roster[i]) {
					return false;
				}
			}
			this.enrolledStudents = this.enrolledStudents + 1;
			roster[getEnrolledStudents() - 1] = s;
			return true;
		}
	}
	/**
	 * getter
	 * @param index
	 * @return the student at that number in the roster
	 */
	public Student getStudentAt(int index) {
		return roster[index];
	}
	/**
	 * getter
	 * @return the first and last names of all students enrolled as a string
	 */
	public String generateRoster() {
		String roster = "";
		for (int i=0; i < this.getEnrolledStudents(); ++i) {
			Student chosen = getStudentAt(i);	
			roster = roster + chosen.getFullName();
		}
		return roster;
	}
	/**
	 * getter
	 * @return the average GPA of the students enrolled in the course
	 */
	public double calculateAverageGPA() {
		double totalGPA = 0;
		for (int i=0; i < this.getEnrolledStudents(); ++i) {
			Student chosen = getStudentAt(i);
			double gPA = chosen.calculateGradePointAverage();
			totalGPA = totalGPA + gPA;
		}
		return (totalGPA / this.getEnrolledStudents());
	}
	/**
	 * getter
	 * @return the course name and the credits it offers as a string
	 */
	public String toString() {
		return this.courseName + this.credits;
	}
	
}
