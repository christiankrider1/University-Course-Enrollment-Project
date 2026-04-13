import java.util.ArrayList;

public class Student {

    private String name;
    private int ID;
    private ArrayList<Course> enrolledCourses = new ArrayList<>();
    private static ArrayList<Student> studentList = new ArrayList<>();

    public Student(String name, int id){
        this.setName(name);
        this.setId(id);
    }


    // Add student to static list
    public static void addStudent(Student student){
        if (findStudentById(student.getId()) != null) {
            System.out.println("Student already exists!");
            return;
        }
        studentList.add(student);
        System.out.println("Student added: " + student.getName());
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
    }


    //Search student by ID
    public static Student findStudentById(int id){
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null; //Student not found
    }

    //Getters & Setters

    public String getName(){
        return name;
    }

    public int getId(){
        return ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.ID = id;
    }

    public ArrayList<Course> getEnrolledCourses(){
        return enrolledCourses;
    }

    public Course findEnrolledCourse(int courseCode){
        for(Course c : enrolledCourses){
            if(c.getCourseCode() == courseCode){
                return c;
            }
        }
        return null; //couldn't find course
    }


    //Enroll student in a course
    public void enroll(Course c){
        enrolledCourses.add(c);
        System.out.println("Course successfully added: " + c.getCourseName());
    }

    //Assigns grade to student for a course
    public void assignGrade(Course c, int grade){
        c.setGrade(grade);
    }
}
