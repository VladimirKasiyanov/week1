package com.kasiyanov.week4.task2.decorator;

import com.kasiyanov.week4.task2.model.Student;

public class StudentDataSourceDecorator implements Student {

    private Student wrappedStudent;

    public StudentDataSourceDecorator(Student student) {
        this.wrappedStudent = student;
    }

    @Override
    public int getMark() {
        return wrappedStudent.getMark();
    }

    @Override
    public int getAcademicYear() {
        return wrappedStudent.getAcademicYear();
    }
}
