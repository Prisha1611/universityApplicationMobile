public class StudentDetails {
    private int studentId;
    private String studentName;
    private String major;

    public StudentDetails(int studentId, String studentName, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.major = major;
    }

    // Getters
    public int getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getMajor() { return major; }
}
