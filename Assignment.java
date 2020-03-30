package mypackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Assignment {

    String title;
    String description;
    LocalDate subDateTime;
    int totalMark;
    private static int count = 0;
    int id;

    
    
     public Assignment() {
        setId(++count);
    }
    public Assignment(String title, String description, LocalDate subDateTime, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.totalMark = totalMark;
        setId(++count);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(String subDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String inputDate = subDateTime;
        LocalDate dateFromString = LocalDate.parse(inputDate, formatter);
        String dateFromLocalDate = dateFromString.format(formatter);
        this.subDateTime = dateFromString;
    }
  
    @Override
    public String toString() {
        return "Assignment{" + "title=" + title + ", description=" + description + ", subDateTime=" + subDateTime + ", totalMark=" + totalMark + ", id=" + id + '}';
    }
    
    public void setTitle(String assignTitle) {
        if(title!=null){
        title = assignTitle;
    }
    }
   
    public String getTitle() {
        return title;
    }

    public void setDescription(String assignDesc) {
        if (description!=null){
        description = assignDesc; }
    }

    public String getDescription() {
        return description;
    }

    public void setTotalMark(int mark) {
        if (mark > 0) {
            totalMark = mark;
        }
    }
    public int getTotalMark() {
        
        return totalMark;

    }

}
