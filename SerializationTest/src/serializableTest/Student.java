package serializableTest;

import java.io.Serializable;

public class Student implements Serializable{
    private Integer studentId;
    private String name;
    private String email;
    private char gender;

    public Student(){}

    public Student(Integer studentId, String name, String email, char gender) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
