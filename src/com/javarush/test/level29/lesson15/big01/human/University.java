package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University{
    private List<Student> students = new ArrayList<>();

    private String name;
    private int age;
    public University(String name, int age) {
        this.name =name;
        this.age =age;
    }
    public Student getStudentWithAverageGrade(double averageGrade) {
        Student studentResult = null;
        for (Student student: students){
            if(student.getAverageGrade()==averageGrade)
            {
                studentResult = student;
                break;
            }
        }
        return studentResult;
    }
    public Student getStudentWithMaxAverageGrade() {
        Student studentResult = null;
        double max = 0;
        for (Student student : students)
        {
            if (student.getAverageGrade() > max)
            {
                max = student.getAverageGrade();
                studentResult = student;
            }
        }
        return studentResult;
    }

    public Student getStudentWithMinAverageGrade(){
        Student studentResult = students.get(0);
        double min = students.get(0).getAverageGrade();
        for (Student student : students)
        {
            if (student.getAverageGrade() < min)
            {
                min = student.getAverageGrade();
                studentResult = student;
            }
        }
        return studentResult;
    }

    public void expel(Student student){
        if (students.contains(student))
        {
            students.remove(student);
        }
    }




    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}