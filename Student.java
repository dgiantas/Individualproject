package mypackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    
    private int id;
    private static int count = 0;
    private String firstName;
    private String lastName;
    private LocalDate DateOfBirth;
    private int tuitionFees;
    private List <Integer> assignmentIds;
    private List <Integer> courseIds ;

    public List<Integer> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Integer> courseIds) {
        this.courseIds = courseIds;
    }

    public List<Integer> getAssignmentIds() {
        return assignmentIds;
    }

    public void setAssignmentIds(List<Integer> assignmentIds) {
        this.assignmentIds = assignmentIds;
    }

    public Student(String firstName, String lastName,LocalDate DateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DateOfBirth = DateOfBirth;
        this.tuitionFees = tuitionFees;
        this.assignmentIds = new ArrayList();
        this.courseIds = new ArrayList();
        setId(++count);
    }

    public Student() {
        this.assignmentIds = new ArrayList();
        this.courseIds = new ArrayList();
        setId(++count);    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setDateOfBirth(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String inputDate = dateOfBirth;
        LocalDate dateFromString = LocalDate.parse(inputDate, formatter);
        String dateFromLocalDate = dateFromString.format(formatter);
        DateOfBirth = dateFromString;
    }
    
    
    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setFirstName(String studentName) {
        if(studentName!=null){
        firstName = studentName;
    }
    }
      public String getFirstName() {
        return firstName;
    }

    public void setLastName(String studentSurname) {
        if(studentSurname!=null){
        lastName = studentSurname;
    }
    }

    public String getLastName() {
        return lastName;
    }

    public void setTuitionFees(int fee) {
        if (fee > 0) {
            tuitionFees = fee;
        }
    }

    public int getTuitionFees() {
        return tuitionFees;

    }
   
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", DateOfBirth=" + DateOfBirth + ", tuitionFees=" + tuitionFees + ", assignmentIds=" + assignmentIds + ", courseIds=" + courseIds + '}';
    }

   

  
    

  

}
