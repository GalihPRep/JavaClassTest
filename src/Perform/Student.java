package Perform;

public class Student {
	public String studentId;
	public String studentName;
	public String department;
	public int mark;
	public double pass = 0.0;
	public Student(
		String studentId,
		String studentName,
		String department,
		int mark
	) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.department = department;
		this.mark = mark;
	}
	public String getStudentId() { return this.studentId; }
	public String getStudentName() { return this.studentName; }
	public String getDepartment() { return this.department; }
	public int getMark() { return this.mark; }
	public double getPass() { return this.pass; }
	public void setPass(double value) { this.pass = value; }
}
