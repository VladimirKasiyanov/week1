package com.kasiyanov.week4.task2.decorator;

import com.kasiyanov.week4.task2.model.Student;
import com.kasiyanov.week4.task2.visitor.Decorator;
import com.kasiyanov.week4.task2.visitor.Visitor;

public class StudentMarkDecorator extends StudentDataSourceDecorator implements Decorator {

    public StudentMarkDecorator(Student student) {
        super(student);
    }

    @Override
    public int getMark() {
        return super.getMark();
    }

    @Override
    public int getAcademicYear() {
        return super.getAcademicYear();
    }

    @Override
    public Integer accept(Visitor visitor) {
        return visitor.visitStudentMarkDecorator(this);
    }
}
