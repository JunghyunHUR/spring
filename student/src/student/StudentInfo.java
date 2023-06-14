package student;

public class StudentInfo {
	
	private Student student;

	//constructor�� �ʱ�ȭ
	public StudentInfo(Student student) {
		this.student = student;
	}

	//method�� �ʱ�ȭ
	public void setStudent(Student student) {
		this.student = student;
	}

	public void getStudentInfo() {
		if(student != null) {
			System.out.println("�̸� : " + student.getName());
			System.out.println("���� : " + student.getAge());
			System.out.println("�г� : " + student.getGradeNum());
			System.out.println("�� : " + student.getClassNum());
			System.out.println("=====================");
		}
	}
}