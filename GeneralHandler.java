/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.handlers;

import java.time.DayOfWeek;
import static java.time.DayOfWeek.SATURDAY;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mypackage.Course;
import mypackage.Student;
import mypackage.Trainer;
import mypackage.Assignment;

/**
 *
 * @author user
 */
public class GeneralHandler {
    
    
    public static void initializeSyntheticRelations(){
        addStudentToCourse(1,1);
        addStudentToCourse(2,1);
        addStudentToCourse(3,2);
        addStudentToCourse(4,2);
        addStudentToCourse(5,3);
        addStudentToCourse(1,3);
        addStudentToCourse(2,4);
        addStudentToCourse(3,4);
        addStudentToCourse(4,5);
        addStudentToCourse(5,5);
        addStudentToCourse(1,6);
        addStudentToCourse(2,6);
        addTrainerToCourse(1,1);
        addTrainerToCourse(1,2);
        addTrainerToCourse(2,3);
        addTrainerToCourse(2,5);
        addTrainerToCourse(3,4);
        addTrainerToCourse(4,6);
        addTrainerToCourse(4,5);
        addTrainerToCourse(1,6);
        addAssignmentToCourse(1,1);
        addAssignmentToCourse(2,2);
        addAssignmentToCourse(3,4);
        addAssignmentToCourse(4,1);
        addAssignmentToStudent(1,1);
        addAssignmentToStudent(2,1);
        addAssignmentToStudent(2,4);
        addAssignmentToStudent(2,3);
        addAssignmentToStudent(3,3);
        addAssignmentToStudent(3,5);
        
    }
    public static void addStudentToCourse(int studentId,int courseId){
        Course c = CourseHandler.getCourseById(courseId);

            c.getStudentIds().add(studentId);
        
        Student st = StudentHandler.getStudentById(studentId);
        
        st.getCourseIds().add(courseId);
    }
    
    public static void addTrainerToCourse(int trainerId,int courseId){
        Course c = CourseHandler.getCourseById(courseId);
        c.getTrainerIds().add(trainerId);
    }
    public static void addAssignmentToCourse(int assignmentId,int courseId){
        Course c = CourseHandler.getCourseById(courseId);
        c.getAssignmentsIds().add(assignmentId);
    }
    public static void addAssignmentToStudent(int assignmentId,int studentId){
        Student st = StudentHandler.getStudentById(studentId);
        st.getAssignmentIds().add(assignmentId);
    }
    
    
    public static List<Student> studentsPerCourse(int courseId){
        List<Integer> studentIds = new ArrayList<>();
        for (Course c: CourseHandler.getCourses()){
            if(c.getId() == courseId)
                studentIds = c.getStudentIds();
        }
        
        List <Student> studentsPerCourse = new ArrayList();
        for(Integer sid : studentIds){
            Student st = StudentHandler.getStudentById(sid);
            studentsPerCourse.add(st);
        }
            return studentsPerCourse;  
        
            
    }
      
    public static List<Trainer> trainersPerCourse(int courseId){
        List<Integer> trainerIds = new ArrayList<>();
        for (Course c: CourseHandler.getCourses()){
            if(c.getId() == courseId)
                trainerIds = c.getTrainerIds();
        }
        
        List <Trainer> trainersPerCourse = new ArrayList();
        for(Integer tid : trainerIds){
            Trainer tr = TrainerHandler.getTrainerById(tid);
            trainersPerCourse.add(tr);
        }
            return trainersPerCourse;  
    
    }
     public static List<Assignment> assignmentsPerCourse(int courseId){
        List<Integer> assignmentIds = new ArrayList<>();
        for (Course c: CourseHandler.getCourses()){
            if(c.getId() == courseId)
                assignmentIds = c.getTrainerIds();
        }
        
        List <Assignment> assignmentsPerCourse = new ArrayList();
        for(Integer aid : assignmentIds){
            Assignment as = AssignmentHandler.getAssignmentById(aid);
            assignmentsPerCourse.add(as);
        }
            return assignmentsPerCourse;  
 
    }
    
     public static List <Assignment> assignmentsPerStudent(int studentId){
         List<Integer> assignmentIds = new ArrayList<>();
        for (Student s: StudentHandler.getStudents()){
            if(s.getId() == studentId)
                assignmentIds = s.getAssignmentIds();
        }
        
        List <Assignment> assignmentsPerStudent = new ArrayList();
        for(Integer aid : assignmentIds){
            Assignment as = AssignmentHandler.getAssignmentById(aid);
            assignmentsPerStudent.add(as);
        }
            return assignmentsPerStudent; 
         
     }
     public static List <Student> studentsWithAssignmentInGivenWeek(LocalDate givenDate){
         List <Student> students = StudentHandler.getStudents();
        
         LocalDate startDate = getStartDate(givenDate);
         LocalDate endDate = getEndDate(givenDate);
         
         List<Student> swaigw = new ArrayList();
         for (Student s: students ){
             boolean deliversThisWeek = false;
            List<Integer> assignmentIds= s.getAssignmentIds();
            for (Integer id:assignmentIds){
                Assignment assignment = AssignmentHandler.getAssignmentById(id);
               if((isBetweenDates(assignment.getSubDateTime(),startDate, endDate)))
                     deliversThisWeek = true;
            }
            if(deliversThisWeek)
                swaigw.add(s);
         }
         return swaigw;
     }
     
     private static boolean isBetweenDates(LocalDate givenDate,LocalDate startDate, LocalDate endDate){
         
         if (startDate.isBefore(givenDate)&& endDate.isAfter(givenDate)){
             return true;
         }
         return false;
 }
    
     private static LocalDate getStartDate(LocalDate date){
          DayOfWeek d = date.getDayOfWeek();
         LocalDate startDate = null;
         
         if(d == SATURDAY)
             startDate = date.minusDays(5L); 
         else if(d == DayOfWeek.SUNDAY)
             startDate = date.minusDays(6L); 
         else if(d == DayOfWeek.FRIDAY)
             startDate = date.minusDays(4L); 
         else if(d == DayOfWeek.THURSDAY)
             startDate = date.minusDays(3L); 
         else if(d == DayOfWeek.WEDNESDAY)
             startDate = date.minusDays(2L); 
         else if(d == DayOfWeek.TUESDAY)
             startDate = date.minusDays(1L); 
         else if(d == DayOfWeek.MONDAY)
             startDate = date; 
         
      return startDate;
     }
     
     private static LocalDate getEndDate(LocalDate date){
          DayOfWeek d = date.getDayOfWeek();
         LocalDate endDate = null;
         
         if(d == SATURDAY)
             endDate = date.minusDays(1L); 
         else if(d == DayOfWeek.SUNDAY)
             endDate = date.minusDays(2L); 
         else if(d == DayOfWeek.FRIDAY)
             endDate = date;
         else if(d == DayOfWeek.THURSDAY)
             endDate = date.minusDays(-1L); 
         else if(d == DayOfWeek.WEDNESDAY)
             endDate = date.minusDays(-2L); 
         else if(d == DayOfWeek.TUESDAY)
             endDate = date.minusDays(-3L); 
         else if(d == DayOfWeek.MONDAY)
             endDate = date.minusDays(-4L);
         
      return endDate;
     }
}
