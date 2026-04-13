public class Course {
    private String courseName;
    private int courseCode, courseCapacity, grade = -1;
    public static int totalEnrolled;

    public Course(){
        totalEnrolled++;
    }

    public String getCourseName(){
        return courseName;
    }

    public int getCourseCode(){
        return courseCode;
    }

    public int getCourseCapacity(){
        return courseCapacity;
    }

    public int getCourseGrade(){
        return grade;
    }

    public void setCourseName(String s){
        this.courseName = s;
        System.out.println("\nCourse name updated");
    }

    public void setGrade(int g){
        grade = g;
        System.out.println("\nGrade updated ");
    }


    public void setCourseCode(int code) {
        courseCode = code;
        System.out.println("Course code set ");
    }

    public void setCourseCapacity(int capacity) {
        courseCapacity = capacity;
    }
}
