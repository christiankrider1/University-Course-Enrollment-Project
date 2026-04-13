import java.util.ArrayList;


public class CourseManagement {
    private static ArrayList<Course> courseList = new ArrayList<Course>();

    public static ArrayList<Course> getCourseArrayList() {
        return courseList;
    }

    //adds a course for a student
    public static void addCourse(String name, int code, int capacity){
        if(courseList.size() > 0){
            for(Course c :courseList){
                if(c.getCourseCode() == code){
                    System.out.println("Course code already exists\nTry again with a different code\n");
                    return;
                }
            }
        }
        Course newCourse = new Course();
        newCourse.setCourseName(name);
        newCourse.setCourseCapacity(capacity);
        newCourse.setCourseCode(code);
        courseList.add(newCourse);
        System.out.println("Successfully added course!\n");
        System.out.println("Name: " + newCourse.getCourseName() + "\nCode: " + newCourse.getCourseCode() + "\nCapacity: " + newCourse.getCourseCapacity());
    }

    //Enrolls student in a course
    public static void enrollStudent(Student student, Course course){
        student.enroll(course);
    }

    //assigns a student a grade for a course
    public static void assignGrade(Student student, Course course, int grade){
        student.assignGrade(course, grade);
        System.out.print(student.getName() + " was assigned a " + grade + " in " + course.getCourseName());
    }

    //Calculates overall grade for a student
    public static void calculateOverallGrade(Student student){
        int sumGrades = 0;
        int totalCourses = 0;
        if(student.getEnrolledCourses().isEmpty()){
            System.out.println("Student doesn't have any classes!\nEnroll student in courses and assign grades");
            return;
        }
        for(Course c : student.getEnrolledCourses()){
            if(c.getCourseGrade() == -1){
                System.out.println("No grade assigned for " + c.getCourseName() + "\nPlease assign grade");
                return;
            }
        }
        for(Course c : student.getEnrolledCourses()){
            sumGrades += c.getCourseGrade();
            totalCourses++;
        }
        int average = (sumGrades/totalCourses);
        System.out.println("Overall grade for this student is " + average + "%");
    }


}
