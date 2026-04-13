import java.util.Scanner;

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean exit = false;
    int code = 0, capacity = 0, id = 0, grade = 0;
    String decision, name = "";
    do{
        System.out.println("\n=========== MAIN MENU ===========\n_____________________________________"); //Prints main menu
        System.out.println("1. Add new course");
        System.out.println("2. Enroll students");
        System.out.println("3. Assign grades ");
        System.out.println("4. Calculate overall course grades");
        System.out.println("5. Exit program");

        decision = input.nextLine();
        if(decision.equals("1") || decision.equals("2") ||decision.equals("3") ||decision.equals("4") ||decision.equals("5")){
            switch(decision){
                //Adds new course with appropriate information
                case "1":
                    System.out.print("\nEnter the name of the course: "); //gathers name of course
                    name = input.nextLine();
                    boolean validInput = false;
                    while(validInput == false){
                        System.out.print("\nEnter the course code (positive integer): ");//gathers course code with input validation
                        String tryCode = input.nextLine();
                        try {
                            code = Integer.parseInt(tryCode);
                            if (code < 0) {
                                System.out.println("Enter positive code number");
                            }else{
                                validInput = true;
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Enter integer please!");
                        }
                    }
                    validInput = false;
                    while(validInput == false){
                        System.out.print("\nEnter the student capacity for this course (positive integer): ");//gathers student capacity with input validation
                        String tryCapacity = input.nextLine();
                        try {
                            capacity = Integer.parseInt(tryCapacity);
                            if (capacity <= 0) {
                                System.out.println("Enter a positive, non-zero number");
                            }else{
                                validInput = true;
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Enter an integer please");
                        }
                    }
                    CourseManagement.addCourse(name, code, capacity);
                    break;
                case "2":
                    //Enrolls a student. If the student doesn't exist, creates the student first
                    Student student = null;
                    System.out.println("Are you enrolling a current student? (yes/no): ");
                    String current = input.nextLine();
                    if (current.equalsIgnoreCase("no")) {
                        // New student
                        System.out.print("Enter student name: "); //Gets student name
                        name = input.nextLine();
                        // Validate student ID
                        while (true) {
                            System.out.print("Enter student ID (positive integer): ");//Gets student ID with input validation, including ensuring a student with this ID doesn't exist
                            String line = input.nextLine();
                            try {
                                id = Integer.parseInt(line);
                                if (id <= 0) {
                                    System.out.println("Enter a positive, non-zero number.");
                                } else {
                                    break; // valid ID
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Enter a valid integer.");
                            }
                        }
                        student = new Student(name, id);
                        Student.addStudent(student);
                    } else if (current.equalsIgnoreCase("yes")) { //If student already exists, searches for this student using ID with input validation
                        // Existing student
                        while (true) {
                            System.out.print("Enter student ID of existing student: ");
                            String line = input.nextLine();
                            try {
                                id = Integer.parseInt(line);
                                if (id <= 0) {
                                    System.out.println("Enter a positive, non-zero number.");
                                } else {
                                    break; // valid ID
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Enter a valid integer.");
                            }
                        }
                        student = Student.findStudentById(id);
                        if (student == null) {
                            System.out.println("No student found with that ID!");
                            break;
                        } else {
                            System.out.println("Found student: " + student.getName());
                        }

                    } else {
                        System.out.println("Invalid input. Please enter yes or no.");
                        break;
                    }

                    // Enroll in course
                    ArrayList<Course> courseList = CourseManagement.getCourseArrayList(); //If no courses exist yet, input user to add courses first before enrolling students
                    if (courseList.isEmpty()) {
                        System.out.println("No courses available. Add courses first!");
                        break;
                    }

                    while (true) {
                        System.out.print("Enter the course code: "); //Gets course code with input validation, enrolling the student if the course exists
                        String line = input.nextLine();
                        try {
                            code = Integer.parseInt(line);
                            if (code <= 0) {
                                System.out.println("Enter a positive, non-zero number.");
                            } else {
                                break; // valid code
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Enter a valid integer.");
                        }
                    }

                    boolean enrolled = false;
                    for (Course c : courseList) {
                        if (c.getCourseCode() == code) {
                            CourseManagement.enrollStudent(student, c);
                            System.out.println(student.getName() + " successfully enrolled in " + c.getCourseName());
                            enrolled = true;
                            break;
                        }
                    }

                    if (!enrolled) {
                        System.out.println("Course code not found. Enrollment failed.");
                    }
                    break;
                case "3":
                    //Assigns grades in particular courses for a particular student
                    while (true) { //Searches for student using ID, with input validation
                        System.out.print("Enter ID of student you wish to assign grades: ");
                        String line = input.nextLine();
                        try {
                            id = Integer.parseInt(line);
                            if (id <= 0) {
                                System.out.println("Enter a positive, non-zero number.");
                            } else {
                                break; // valid ID
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Enter a valid integer.");
                        }
                    }

                    student = Student.findStudentById(id);
                    if (student == null) {
                        System.out.println("No student found with that ID!");
                        break;
                    } else {
                        System.out.println("Found student: " + student.getName());
                    }
                    //If student is found, get course ID, with input validation
                    while (true) {
                        System.out.print("Enter course ID: ");
                        String line = input.nextLine();
                        try {
                            code = Integer.parseInt(line);
                            if (code <= 0) {
                                System.out.println("Enter a positive, non-zero number.");
                            } else {
                                break; // valid code
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Enter a valid integer.");
                        }
                    }
                    Course course = student.findEnrolledCourse(code); //Ensures that student is enrolled in the course
                    if(course == null){
                        System.out.println("Student is not enrolled in that course.");
                        break;
                    }
                    //If enrolled, get the grade, with input validation
                    while (true) {
                        System.out.print("Enter a grade 0-100 for this course: ");
                        String line = input.nextLine();
                        try {
                            grade = Integer.parseInt(line);
                            if (grade < 0 || grade > 100) {
                                System.out.println("Enter an integer from 0-100.");
                            } else {
                                break; // valid code
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Enter a valid integer.");
                        }
                    }
                    CourseManagement.assignGrade(student, course, grade); //Assign student the grade for the course

                    break;
                case "4":
                    //Calculates overall grade for all courses for a specific student
                    while (true) {
                        System.out.print("Enter the student's ID: ");//Validates students ID
                        String line = input.nextLine();
                        try {
                            id = Integer.parseInt(line);
                            if (id <= 0) {
                                System.out.println("Enter a positive, non-zero number.");
                            } else {
                                break; // valid code
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Enter a valid integer.");
                        }
                    }
                    Student s = Student.findStudentById(id); //If valid, calculates the overall grade for this student

                    //Calculate grades for this student
                    CourseManagement.calculateOverallGrade(s);
                    break;
                case "5":
                    //Ends the program
                    exit = true;
                    System.out.println("Bye!");
                    break;
            }
        }
        else{
            System.out.println("\nInvalid option!\nThe menu options are 1, 2, 3, 4, or 5"); //Input validation for menu options
        }
    }while(exit == false);
}
