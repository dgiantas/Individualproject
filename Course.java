package mypackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Course {

    private static int count = 0;
    private int id;

    private String title;
    private String stream;
    private String type;
    LocalDate start_date;
    LocalDate end_date;
    List<Integer> studentIds;
    List<Integer> trainerIds;
    List<Integer> assignmentsIds;

    public Course() {
        setId(++count);
        this.studentIds = new ArrayList();
        this.trainerIds = new ArrayList();
        this.assignmentsIds = new ArrayList();
    }

    public Course(String title, String stream, String type, LocalDate start_date, LocalDate end_date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
        this.studentIds = new ArrayList();
        this.trainerIds = new ArrayList();
        this.assignmentsIds = new ArrayList();
        setId(++count);
    }

    public List<Integer> getAssignmentsIds() {
        return assignmentsIds;
    }

    public void setAssignmentsIds(List<Integer> assignmentsIds) {
        this.assignmentsIds = assignmentsIds;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + ", stream=" + stream + ", type=" + type + ", start_date=" + start_date + ", end_date=" + end_date + '}';
    }

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public List<Integer> getTrainerIds() {
        return trainerIds;
    }

    public void setTrainerIds(List<Integer> trainerIds) {
        this.trainerIds = trainerIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }

    public void setStart_date(String startDate2) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String inputDate = startDate2;
        LocalDate dateFromString = LocalDate.parse(inputDate, formatter);
        String dateFromLocalDate = dateFromString.format(formatter);
        start_date = dateFromString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getType() {
        return type;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public static int getCount() {
        return count;
    }

    public void setTitle(String a) {
        if (title != null) {
            title = a;
        }
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String endDate2) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String inputDate = endDate2;
        LocalDate dateFromString = LocalDate.parse(inputDate, formatter);
        String dateFromLocalDate = dateFromString.format(formatter);
        end_date = dateFromString;
    }

    public String getTitle() {
        return title;
    }

    public void setStream(String b) {
        if (b != null) {
            stream = b;
        }
    }

    public String getStream() {
        return stream;
    }

    public void setType(String c) {
        if (c != null) {
            type = c;
        }
    }

}
