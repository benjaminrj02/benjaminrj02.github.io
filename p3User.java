package model;

import java.io.Serializable;

/**
 *
 * @author John Phillips
 */
public class User implements Serializable {

    private int id;
    private String email;
    private int grades;
    private String date;
    private String time;
    private String notes;

    public User() {
        id = 0;
        email = "none@test.com";
        grades = 0;
        date = "1970-01-01";
        time = "00:01 AM";
        notes = "none";
    }

    public User(int id, String email, int grades, String date, String time, String notes) {
        this.id = id;
        this.email = email;
        this.grades = grades;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String inHTMLRowFormat() {
        return "<tr><td>" + id + "</td>"
                + "<td>" + email + "</td>"
                + "<td>" + grades + "</td>"
                + "<td>" + date + "</td>"
                + "<td>" + time + "</td>"
                + "<td>" + notes + "</td></tr>\n";
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", grades="
                + grades + ", date=" + date + ", time=" + time
                + ", notes=" + notes + '}';
    }
}
