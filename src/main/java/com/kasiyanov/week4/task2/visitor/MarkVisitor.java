package com.kasiyanov.week4.task2.visitor;

import com.kasiyanov.week4.task2.decorator.StudentMarkDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class MarkVisitor implements Visitor {

    private List<Integer> marksList = new ArrayList<>();

    public void insertCurrentStudentMark(Decorator decorator) {
        marksList.add(decorator.accept(this));
    }

    public OptionalDouble getAvgMark() {
        return marksList.stream().mapToInt(Integer::intValue).average();
    }

    public List<Integer> getAllMarks() {
        return marksList;
    }

    @Override
    public Integer visitStudentMarkDecorator(StudentMarkDecorator studentMarkDecorator) {
        return studentMarkDecorator.getMark();
    }
}
