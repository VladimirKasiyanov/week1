package com.kasiyanov.week4.task2.visitor;

import com.kasiyanov.week4.task2.decorator.StudentMarkDecorator;

public interface Visitor {

    Integer visitStudentMarkDecorator(StudentMarkDecorator studentMarkDecorator);
}
