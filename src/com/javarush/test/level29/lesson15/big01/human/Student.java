package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;
    private int course;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name,age);
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }
    public int getCourse() {
        return course;
    }


    public void setAverageGrade(double averageGrade)
    {
        this.averageGrade = averageGrade;
    }

    public void setCourse(int course)
    {
        this.course = course;
    }

    public void incAverageGradeBy01()
    {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02()
    {
        averageGrade += 0.2;
    }

    public void setBeginningOfSession(int day, int month, int year) {
        beginningOfSession = new Date(year, month, day);
    }

    public void setEndOfSession(int day, int month, int year) {
        endOfSession = new Date(year, month, day);
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String getPosition()
    {
        return "Студент";
    }
}
